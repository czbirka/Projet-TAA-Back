package m2.ila.projet.taa.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import m2.ila.projet.taa.back.model.User;

public class UserDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

	// public PersonDAO() {
	// super(manager);
	// }

	// Person DAO
	// @Override
	public boolean create(User p) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(p);
		tx.commit();
		return true;
	}

	// @Override
	public boolean delete(User p) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(p);
		tx.commit();
		return true;
	}

	// @Override
	public boolean update(User p) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(p);
		tx.commit();
		return true;
	}

	public List<User> findAll() {
		List<User> result = new ArrayList<User>();
		try {
			result = manager.createQuery("select u from User as u").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Optional<User> findOneById(long id) {
		Optional<User> user = Optional.empty();
		try {
			user = Optional.of(manager.createQuery("select u from User as u where u.id = :id", User.class)
					.setParameter("id", id).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

//	public Optional<User> findOneByName(String name) {
//		Optional<User> person = Optional.empty();
//		try {
//			person = Optional.of(manager.createQuery("select u from User as u where u.nom = :name", User.class)
//					.setParameter("name", name).getSingleResult());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return person;
//	}
	
//	public List<User> findByName(String name) {
//		//Optional<User> person = Optional.empty();
//		List<User> liste = new ArrayList<User>();
//		try {
//			liste = manager.createQuery("select u from User as u where u.nom = :name", User.class)
//					.setParameter("name", name).getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return liste;
//	}

	public List<User> findByName(String name) {
	    List<User> liste = new ArrayList<User>();
	    
	    liste = manager.createQuery("select u from User u where u.name = :name", User.class)
	    		.setParameter("name", name)
	    		.getResultList();
		return liste;
	}
	
}
