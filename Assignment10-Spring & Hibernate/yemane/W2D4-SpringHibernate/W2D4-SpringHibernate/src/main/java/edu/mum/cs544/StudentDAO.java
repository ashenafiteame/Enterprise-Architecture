package edu.mum.cs544;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class StudentDAO {
    @PersistenceContext
    EntityManager em;

    public Student load(long studentid) {

//        EntityGraph<Student> graph = em.createEntityGraph(Student.class);
//        graph.addAttributeNodes("courselist");
//        Map<String, Object> hints = new HashMap<String,Object>();
//        hints.put("javax.persistence.fetchgraph", graph);
        return em.find(Student.class, studentid);
    }
}
