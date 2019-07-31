package net.sid.eco.entities;

import java.io.Serializable;

public class LigneCommande implements Serializable {
	private Long id;
	private int quantite;
	private int prix;
	private Produit produit;
	private Commande commande;
	
	
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public LigneCommande(int quantite, int prix) {
		super();
		this.quantite = quantite;
		this.prix = prix;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
