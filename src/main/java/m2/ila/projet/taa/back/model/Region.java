package m2.ila.projet.taa.back.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Region {

	long id;
	String nom;

	private List<Departement> departements = new ArrayList<Departement>();

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

	@OneToMany(mappedBy="region", cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JsonManagedReference
	//@OneToMany(mappedBy="region")
	public List<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(List<Departement> departements) {
		this.departements = departements;
	}
	
	public void addDepartement(Departement dept) {
		this.getDepartements().add(dept);
	}

}
