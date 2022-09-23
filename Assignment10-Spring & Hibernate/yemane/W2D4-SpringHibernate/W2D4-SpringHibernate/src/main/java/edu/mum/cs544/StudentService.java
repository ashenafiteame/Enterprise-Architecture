package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService {
	@Autowired
	private StudentDAO studentdao;
	@PersistenceContext
	EntityManager em;

	public StudentService() {

	}

	public Student getStudent(long studentid) {
//		em.getTransaction().begin();
		Student student = studentdao.load(studentid);
//		em.getTransaction().commit();
//		em.close();
		return student;
	}
}
