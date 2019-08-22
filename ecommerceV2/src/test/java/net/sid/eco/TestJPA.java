package net.sid.eco;

import static org.junit.Assert.*;

import java.util.List;

import javassist.ClassPath;
import net.sid.eco.entities.Categorie;
import net.sid.eco.entities.Produit;
import net.sid.eco.metier.IAdminCategoriesMetier;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	ClassPathXmlApplicationContext context;
	
	@Before
	public void setUp() throws Exception {
		
	context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
	}

	@Test
	public void testCat1() {

		try {
			
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context
					.getBean("metier");
			List<Categorie> cts1 = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateur", "Ordineuff",
					null, "image11.jpg"));
			metier.ajouterCategorie(new Categorie("imprimante", "impocasion",
					null, "image21.jpg"));
			List<Categorie> cts2 = metier.listCategories();
			assertTrue(cts1.size()+2== cts2.size());
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}

	}

	@Test
	public void testProduit() {

		try {
			
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context
					.getBean("metier");
			List<Produit> prods1=metier.listproduits();
			metier.ajouterProduit(new Produit("HP4521ERT1", "HP789001", 6000,3, true, "imag1.jpg"), 1L);
			metier.ajouterProduit(new Produit("DELL02ZE1", "DELL7023", 8000,2, true, "imag2.jpg"), 1L);
			List<Produit>prods2=metier.listproduits();
			assertTrue(prods2.size()== prods1.size()+2);
		} catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}

	}
	// @Test
	// public void test1() {
	// try {
	// ClassPathXmlApplicationContext app=
	// new ClassPathXmlApplicationContext(new
	// String[]{"applicationContext.xml"});
	// assertTrue(true);
	// } catch (Exception e) {
	// assertTrue(e.getMessage(),false);
	// }
	// }

}
