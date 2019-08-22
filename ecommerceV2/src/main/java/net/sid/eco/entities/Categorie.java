package net.sid.eco.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
    @NotEmpty
    @Size(min=4,max=20)
	private String nomCategorie;
    @Size(min=8)
	private String description;
	@Lob
	private byte[] photo;
	private String nomPhoto;
	@OneToMany(mappedBy="categorie")
	private Collection<Produit> produits;
	
	// constructors 
	
	public Categorie() {
		super();
		
	}
	
	
	
	public Categorie(String nomCategorie, String description, byte[] photo,
			String nomPhoto) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
		this.photo = photo;
		this.nomPhoto = nomPhoto;
	}


// getters and setters

	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idcategorie) {
		this.idCategorie = idcategorie;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomPhoto() {
		return nomPhoto;
	}
	public void setNomPhoto(String nomPhoto) {
		this.nomPhoto = nomPhoto;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}

}
