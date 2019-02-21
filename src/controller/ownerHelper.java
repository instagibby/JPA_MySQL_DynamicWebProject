package controller;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Owner;

public class ownerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_MYSQL");

	public void insertOwner(Owner o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	


	public List<Owner> showAllOwners() {
		EntityManager em = emfactory.createEntityManager();
		List<Owner> allOwners = em.createQuery("SELECT i FROM Owner i ").getResultList();
		return allOwners;
	}
	
	

}
