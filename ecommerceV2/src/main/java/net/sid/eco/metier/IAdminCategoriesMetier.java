package net.sid.eco.metier;

import net.sid.eco.entities.Categorie;
import net.sid.eco.entities.Role;
import net.sid.eco.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {
	public Long ajouterCategorie(Categorie c);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);
}
