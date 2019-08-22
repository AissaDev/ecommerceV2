package net.sid.eco.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import net.sid.eco.entities.Categorie;
import net.sid.eco.metier.IAdminCategoriesMetier;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/adminCat")
public class AdminCategoriesController implements HandlerExceptionResolver {
	@Autowired
	private IAdminCategoriesMetier metier;
	@RequestMapping(value="/index")
	public String index(Model model){
		 model.addAttribute("categorie",new Categorie());
		 model.addAttribute("categories",metier.listCategories());
		 return "categories";
	}
//	@RequestMapping(value = "/indexbis", method = RequestMethod.POST)
//	public String submit(@Valid @ModelAttribute("categorie")Categorie categorie, 
//	  BindingResult result,  ModelMap model) {
//	    if (result.hasErrors()) {
//	        return "error";
//	    }
//	     
//	    //Do Something
//	    return "categoriesView";
//	}
	@RequestMapping(value="/saveCat")
	public String saveCat(@Valid Categorie c,BindingResult bindingResult,
			Model model,MultipartFile file) throws IOException{
		if(bindingResult.hasErrors()){
			model.addAttribute("categories",metier.listCategories());
			return("categories");
		}
		if(!file.isEmpty()) {
			BufferedImage bi=ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes()); 
			c.setNomPhoto(file.getOriginalFilename());
		}
		// travail a faire a completer c'est de essai de modifier la condition 1 afin de charger que la photo si besoin de modifier que la photo 
		if(c.getIdCategorie()!=null){ //.....1
				if(file.isEmpty()){
				 Categorie cat=metier.getCategorie(c.getIdCategorie());
				 c.setPhoto(cat.getPhoto());
				}
			metier.modifierCategorie(c);
		}
		else
		metier.ajouterCategorie(c);
		 model.addAttribute("categorie",new Categorie());
		 model.addAttribute("categories",metier.listCategories());
		 return "categories";
	}	
	@RequestMapping(value="photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException{
		Categorie c=metier.getCategorie(idCat);
		
		if(c.getPhoto()==null) return new byte[0];
		else return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
	@RequestMapping(value="/suppCat")
	public String supp(Long idCat,Model model){
		 metier.supprimerCategrorie(idCat);
		 model.addAttribute("categorie",new Categorie());
		 model.addAttribute("categories",metier.listCategories());
		 return "categories";
	}
	@RequestMapping(value="/editCat")
	public String edit(Long idCat,Model model){
		 Categorie c=metier.getCategorie(idCat);
		 model.addAttribute("categorie",c);
		 model.addAttribute("categories",metier.listCategories());
		 return "categories";
	}
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("categorie", new Categorie());
		mv.addObject("categories",metier.listCategories());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}
}
