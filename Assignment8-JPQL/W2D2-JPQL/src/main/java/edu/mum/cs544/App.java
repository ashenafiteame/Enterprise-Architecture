package edu.mum.cs544;

import edu.mum.cs544.model.Airline;
import edu.mum.cs544.model.Flight;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;

public class App {

	private static EntityManagerFactory emf;

    public static void main(String[] args) throws Exception {
        emf = Persistence.createEntityManagerFactory("cs544");
        		
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        // a) TODO: Flights leaving USA capacity > 500
        System.out.println("Question A:");
        List<Flight> flights = em.createQuery("from Flight ", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // b) TODO: All airlines that use A380 airplanes
        System.out.println("Question B:");
        List<Airline> airlines = em.createQuery("from Airline ", Airline.class).getResultList();
        System.out.println("Airlines that use A380s:");
        for (Airline airline : airlines) {
            System.out.println(airline.getName());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // c) TODO: Flights using 747 planes that don't belong to Star Alliance
        System.out.println("Question C:");
        flights = em.createQuery("from Flight ", Flight.class).getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();

        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
                Locale.US);
        DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
                Locale.US);

        // d) TODO: All flights leaving before 12pm on 08/07/2009
        System.out.println("Question D:");
        TypedQuery<Flight> query = em.createQuery("from Flight ", Flight.class);
        flights = query.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:",
                "Arrives:");
        for (Flight flight : flights) {
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println();
        em.getTransaction().commit();
        em.close();


        em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("______________________________________________All flights leaving the USA with a capacity > 500_________________________________________________________________");

        TypedQuery<Flight> query1 = em.createQuery("select  f from Flight  as f JOIN f.airplane as a  where f.origin.country =:originCountry AND a.capacity > 500",Flight.class);
        query1.setParameter("originCountry","USA");
        List<Flight> filteredFlights = query1.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");
        for (Flight flight : filteredFlights){
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }

        System.out.println("______________________________________________Airline with A380 model airplane_________________________________________________________________");

        TypedQuery<Airline> query2 = em.createQuery("select distinct airline from Airline as airline join airline.flights as flights where flights.airplane.model = 'A380'",Airline.class);
//        System.out.println();

        List<Airline> airlineList = query2.getResultList();
        for (Airline airline : airlineList){
            System.out.println(airline.getName());
        }

        System.out.println("______________________________________________Flight of 747 that does not belong to Star-Alliance_________________________________________________________________");

        TypedQuery<Flight> query3 = em.createQuery("select flight from Flight  as flight join flight.airline as airline where flight.airplane.model =:modelNumber and airline.name <> :name",Flight.class);

        query3.setParameter("name","Star Alliance");
        query3.setParameter("modelNumber","747");
        List<Flight> flightList = query3.getResultList();
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");

        for (Flight flight : flightList){
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }
        System.out.println("______________________________________________All flights leaving before 12pm on 08/07/2009_________________________________________________________________");

//        Query query = em.createQuery("delete Book where publish_date < :date");
//        DateFormat df = DateFormat.getDateInstance(); query.setParameter("date", df.parse("01/01/2010"), TemporalType.DATE);


        TypedQuery<Flight> query4 = em.createQuery("select flight from Flight  as flight where flight.departureDate= :date",Flight.class);
        DateFormat dateFormat = DateFormat.getDateInstance();
        query4.setParameter("date",df.parse("08/07/2009"),TemporalType.DATE);
        System.out.printf("%-9s%-31s%-31s\n", "Flight:", "Departs:", "Arrives:");

        for (Flight flight : flightList){
            System.out.printf("%-7s  %-12s %7s %8s  %-12s %7s %8s\n",
                    flight.getFlightnr(), flight.getOrigin().getCity(),
                    flight.getDepartureDate(), flight.getDepartureTime(),
                    flight.getDestination().getCity(),
                    flight.getArrivalDate(), flight.getArrivalTime());
        }


    }
}
