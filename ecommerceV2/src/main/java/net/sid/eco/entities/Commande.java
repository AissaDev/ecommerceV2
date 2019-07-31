package net.sid.eco.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Commande implements Serializable{
	
	private Long idCommande;
	private Date dateCommande;
    private Collection<LigneCommande> items;
    private Client client;
    
    
      
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Long getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Long idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Collection<LigneCommande> getItems() {
		return items;
	}
	public void setItems(Collection<LigneCommande> items) {
		this.items = items;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
    
    
}
