package m2.ila.projet.taa.back.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import m2.ila.projet.taa.back.model.Activite;

public class ActiviteDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();

//	public SportDAO(EntityManager manager) {
//		super(manager);
//		// TODO Auto-generated constructor stub
//	}
	
	public List<Activite> findAll() {
		List<Activite> result = new ArrayList<Activite>();
		try {
			result = manager.createQuery("select s from Sport as s").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Optional<Activite> findOneById(long id) {
		Optional<Activite> sport = Optional.empty();
		try {
			sport = Optional.of(manager.createQuery("select s from Sport as s where s.id = :id", Activite.class)
					.setParameter("id", id).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sport;
	}
	
	public Optional<Activite> findOneByName(String name) {
		Optional<Activite> sport = Optional.empty();
		try {
			sport = Optional.of(manager.createQuery("select s from Sport as s where s.nom = :name", Activite.class)
					.setParameter("name", name).getSingleResult());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sport;
	}
	
	public boolean create(Activite s) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.persist(s);
		tx.commit();
		return true;
	}
	
	public boolean update(Activite s) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.merge(s);
		tx.commit();
		return true;
	}

	public boolean delete(Activite s) {
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		manager.remove(s);
		tx.commit();
		return true;
	}
	
}
