package com.ors.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ors.entity.ORSMainCategories;
import com.ors.service.MainCategoriesService;


@Controller
@RequestMapping("/admin/*")
public class MainCategoriesController {
	
	@Autowired
	private MainCategoriesService mainCatgService;
	
	public MainCategoriesController() {
		System.out.println("MainCategories Controller");
	}
	
	@RequestMapping(value="/homePage",method=RequestMethod.GET)
	public ModelAndView adminIndex(ModelAndView model){
		model.setViewName("adminIndex");
		return model;
	}
	
	@RequestMapping(value="/mainCategories",method=RequestMethod.GET)
	public ModelAndView listMainCatgs(ModelAndView model){
		List<ORSMainCategories> listMainCatgs=mainCatgService.getAllMainCatgs();
		model.addObject("listMainCatgs",listMainCatgs);
		model.setViewName("displayMainCatgs");
		return model;
	}

	@RequestMapping(value="/addMainCategories" ,method=RequestMethod.GET)
	public ModelAndView index(ModelAndView model){
		ORSMainCategories catg=new ORSMainCategories();
		model.addObject("catg",catg);
		model.setViewName("addMainCatgs");
		return model;
	}
	
	@RequestMapping(value="/saveMainCatergories",method=RequestMethod.POST)
	public ModelAndView saveMainCatg(@ModelAttribute ORSMainCategories mainCatg){
		
			if(mainCatg.getOrs_mc_id()==null){
				mainCatg.setOrs_mc_status("1");
				mainCatg.setOrs_mc_create_date(dateAndTime());
				mainCatgService.addMainCatgs(mainCatg);
			}else{
				mainCatgService.updateCatgs(mainCatg);
			}
		return new ModelAndView("redirect:/admin/mainCategories");
	}

	@ModelAttribute("alphabetOrder")
	public Map<String,String> getAlphabetOrder(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		for (int i = 65; i <= 90; i++) {
		      map.put(Character.toString((char) i), Character.toString((char) i));
		}
		return map;
	}
	
	public String dateAndTime(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    return formatter.format(date);
	}
	
	
	@RequestMapping(value="/deleteMainCatgs",method=RequestMethod.GET)
	public ModelAndView deleteMainCatgs(@RequestParam int id,ModelAndView model){
		mainCatgService.deleteMainCatg(id);
		return new ModelAndView("redirect:/admin/mainCategories");
	}
	
	@RequestMapping(value="/editMainCatgs")
	public ModelAndView editMainCatgs(@RequestParam int id,ModelAndView model){
		System.out.println("Edit Id"+  id);
	ORSMainCategories main=mainCatgService.getMainCatg(id);
	model.addObject("catg",main);
	model.setViewName("addMainCatgs");
	
		return model;
	}
}
