package edu.mum.cs544;

public class Borders implements IBookSupplier{

    public double computePrice(String isbn) {
        double price = Math.random() * 5;
        System.out.println("Borders charges $" + price + " for book with isbn "
                + isbn);
        return price;
    }

    public void order(Book book) {
        System.out.println("Book with isbn = " + book.getIsbn()
                + " is ordered from Borders");
    }
}
