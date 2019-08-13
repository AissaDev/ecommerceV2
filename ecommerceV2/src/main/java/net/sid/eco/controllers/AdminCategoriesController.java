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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategoriesController implements HandlerExceptionResolver {

	@Autowired
	private IAdminCategoriesMetier metier;

	@RequestMapping(value = "/index")
	// @ResponseBody
	public String index(Model model) {
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";

	}

	@RequestMapping(value = "/saveCat")
	// @ResponseBody
	public String saveCat(@Valid Categorie c,BindingResult bindingResult,
			Model model,MultipartFile file ) throws IOException {
		
		if(bindingResult.hasErrors()){
			model.addAttribute("categories", metier.listCategories());
			c.setPhoto(file.getBytes());
			return("categories");
		}
		if(!file.isEmpty()){
			BufferedImage bi= ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		
		metier.ajouterCategorie(c);
		
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());
		return "categories";

	}
	@RequestMapping(value="photoCat",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photCat(Long idCat) throws IOException{
		Categorie c=metier.getCategorie(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}

}
