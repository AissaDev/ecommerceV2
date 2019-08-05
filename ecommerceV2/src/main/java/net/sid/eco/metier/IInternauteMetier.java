package net.sid.eco.metier;

import java.util.List;

import net.sid.eco.entities.Categorie;
import net.sid.eco.entities.Client;
import net.sid.eco.entities.Commande;
import net.sid.eco.entities.Panier;
import net.sid.eco.entities.Produit;

public interface IInternauteMetier {

	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public Commande enregistrerCommande(Panier p,Client c);
}
