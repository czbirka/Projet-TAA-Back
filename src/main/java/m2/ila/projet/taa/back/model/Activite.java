package m2.ila.projet.taa.back.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Activite {
	
	private long id;
	private String nom;
	private Condition condition;
	
	private List<Lieu> lieux = new ArrayList<Lieu>();
	private User user;
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Embedded
	public Condition getCondition() {
		return condition;
	}
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Lieu> getLieux() {
		return lieux;
	}
	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
	
	@ManyToOne
	@JsonIgnore
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public void addLieu(Lieu lieu) {
		this.getLieux().add(lieu);
	}
	
	
	
	
	
	/*
	private long id;
	private String nom;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	//private List<User> users = new ArrayList<User>();
	
	//@ManyToMany
	//@JsonIgnore
	private List<Lieu> lieux = new ArrayList<Lieu>();

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

//	@ManyToOne
//	public List<User> getUsers() {
//		return users;
//	}

//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

	@ManyToMany
	//@JsonIgnore
	public List<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(List<Lieu> lieux) {
		this.lieux = lieux;
	}
	
	public void addLieu(Lieu lieu) {
		this.getLieux().add(lieu);
	}
	
	@Embedded
	private Condition condition;

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	//@ManyToOne
	//@JsonBackReference
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	*/
}
