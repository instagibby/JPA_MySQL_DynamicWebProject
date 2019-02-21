package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Cat;

public class petHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPA_MYSQL");

	public void insertPet(Cat c) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}

	public List<Cat> showAllPets() {
		EntityManager em = emfactory.createEntityManager();
		List<Cat> allPets = em.createQuery("SELECT i FROM Cat i").getResultList();
		return allPets;
	}

	public void deleteCat(Cat toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Cat> typedQuery = em.createQuery(
				"select c from Cat c where c.name = :selectedName and c.breed = :selectedBreed", Cat.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedBreed", toDelete.getBreed());
		// we only want one result
		typedQuery.setMaxResults(1);
		// get the result and save it into a new list item
		Cat result = typedQuery.getSingleResult();
		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<Cat> searchForCatByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Cat> typedQuery = em.createQuery("select c from Cat c where c.name = :selectedPet", Cat.class);
		typedQuery.setParameter("selectedPet", name);
		List<Cat> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Cat> searchForCatByBreed(String catBreed) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Cat> typedQuery = em.createQuery("select c from Cat c where c.breed = :selectedPet", Cat.class);
		typedQuery.setParameter("selectedPet", catBreed);
		List<Cat> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public Cat searchForCatById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Cat found = em.find(Cat.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(Cat toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public void cleanUp() {
		emfactory.close();
	}

}
