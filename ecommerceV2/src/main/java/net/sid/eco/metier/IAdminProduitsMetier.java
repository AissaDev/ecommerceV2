package net.sid.eco.metier;

import net.sid.eco.entities.Produit;

public interface IAdminProduitsMetier extends IInternauteMetier {

	public Long ajouterProduit(Produit p, Long idCat);

	public void supprimerProduit(Long idP);

	public void modifierProduit(Produit p);

}
