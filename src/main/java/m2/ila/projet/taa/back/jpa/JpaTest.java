package m2.ila.projet.taa.back.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import m2.ila.projet.taa.back.model.Activite;
import m2.ila.projet.taa.back.model.Condition;
import m2.ila.projet.taa.back.model.Departement;
import m2.ila.projet.taa.back.model.Lieu;
import m2.ila.projet.taa.back.model.Region;
import m2.ila.projet.taa.back.model.User;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		// EntityManagerFactory factory =
		// Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();

		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createData();

			// test.createPersons();
			// test.createLieux();
			// test.createSports();
			// test.createRegions();
			// test.createDepartements();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		// test.listPersons();
		// test.listLieux();
		// test.listSports();
		// test.listRegions();
		// test.listDepartements();

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
	}

	private void createData() {
		
		User u1 = new User();
		u1.setNom("Bambois");
		u1.setPrenom("Jean");
		u1.setLogin("jeanbambois");
		u1.setMotDePasse("jbpassword");
		u1.setEmail("jean.bambois@azertyuiop.xyz");
		manager.persist(u1);
		User u2 = new User();
		u2.setNom("Deffaire");
		u2.setPrenom("Phil");
		u2.setLogin("phildeffaire");
		u2.setMotDePasse("pdpassword");
		u2.setEmail("phil.deffaire@azertyuiop.xyz");
		manager.persist(u2);
		User u3 = new User();
		u3.setNom("Terieur");
		u3.setPrenom("Alain");
		u3.setLogin("alainterieur");
		u3.setMotDePasse("atpassword");
		u3.setEmail("alain.terieur@azertyuiop.xyz");
		manager.persist(u3);
		User u4 = new User();
		u4.setNom("Terieur");
		u4.setPrenom("Alex");
		u4.setLogin("alexterieur");
		u4.setMotDePasse("atpassword2");
		u4.setEmail("alex.terieur@azertyuiop.xyz");
		manager.persist(u4);
		
		Region r1 = new Region();
		r1.setNom("Bretagne");
		manager.persist(r1);
		Region r2 = new Region();
		r2.setNom("Normandie");
		manager.persist(r2);

		Departement d1 = new Departement();
		d1.setNom("Ille-et-Vilaine");
		manager.persist(d1);
		Departement d2 = new Departement();
		d2.setNom("Morbihan");
		manager.persist(d2);
		Departement d3 = new Departement();
		d3.setNom("Manche");
		manager.persist(d3);

		Activite a1 = new Activite();
		a1.setNom("Football");
		Condition c1 = new Condition(1.5, 2.3,  5.9, 7.5, 5, 15.3, 25.6, 35.6);
		//c1.setVentMin(1.5);
		//c1.setVentInf(2.5);
		//c1.setVentSup(5.23);
		//c1.setVentMax(7.12);
		a1.setCondition(c1);
		manager.persist(a1);
		
//		
/*
		
		//manager.persist(a1);
//		Activite a2 = new Activite();
//		a2.setNom("Jokari");
//		manager.persist(a2);
//		Activite a3 = new Activite();
//		a3.setNom("Planche à voile");
//		manager.persist(a3);		
		
		//
		Lieu l1 = new Lieu();
		l1.setNom("Lieu1");
		Lieu l2 = new Lieu();
		l2.setNom("Lieu2");
		Lieu l3 = new Lieu();
		l3.setNom("Lieu3");
		Lieu l4 = new Lieu();
		l4.setNom("Lieu4");
		Lieu l5 = new Lieu();
		l5.setNom("Lieu5");

		

		manager.persist(l1);
		manager.persist(l2);
		manager.persist(l3);
		manager.persist(l4);
		manager.persist(l5);

		

		
		

		// l1.addSport(s1);
		// l1.addSport(s2);

		a1.addLieu(l1);
		a2.addLieu(l1);
		a3.addLieu(l1);
		a2.addLieu(l2);

		d1.setRegion(r1);
		d2.setRegion(r1);
		d3.setRegion(r2);

		l1.setDepartement(d1);
		l2.setDepartement(d1);
		l3.setDepartement(d2);
		l4.setDepartement(d3);
		l5.setDepartement(d3);

		u1.addActivite(a1);
		u1.addActivite(a2);
		u2.addActivite(a1);
		u2.addActivite(a3);

		u1.addLieu(l1);
		u1.addLieu(l2);
		u1.addLieu(l3);
		u1.addLieu(l4);
		u2.addLieu(l3);
		u2.addLieu(l4);
		u2.addLieu(l5);*/

	}



}
