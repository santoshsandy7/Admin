package com.ors.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ors.entity.ORSMainCategories;
import com.ors.entity.ORSSubCategories;
import com.ors.service.SubCategoriesService;

@Controller
@RequestMapping("/admin/*")
public class SubCatgsController {

	@Autowired
	private SubCategoriesService subcatgsService;

	@RequestMapping(value = "/subCategories", method = RequestMethod.GET)
	public ModelAndView listMainCatgs(ModelAndView model) {
		List<ORSSubCategories> orsSubCatgs = subcatgsService.getAllSubCatgs();
		model.addObject("listSubCatgs", orsSubCatgs);
		model.setViewName("displaySubCatgs");
		return model;
	}

	@RequestMapping(value = "/addSubCategories", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView model) {
		ORSSubCategories subcatg = new ORSSubCategories();
		model.addObject("subcatg", subcatg);
		model.setViewName("addSubCatgs");
		return model;
	}

	@RequestMapping(value = "/saveSubCatgs", method = RequestMethod.POST)
	public ModelAndView savesaveSubCatgs(@ModelAttribute ORSSubCategories subCatg) {
		if (subCatg.getOrs_sub_id() == null) {
			subCatg.setOrs_sub_status("1");
			subCatg.setOrs_sub_create_date(dateAndTime());
			subcatgsService.addSubCatgs(subCatg);
		}else{
			subCatg.setOrs_sub_status("1");
			subCatg.setOrs_sub_create_date(dateAndTime());
			subcatgsService.updateSubCatg(subCatg);
		}
		return new ModelAndView("redirect:/admin/subCategories");
	}

	public String dateAndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}

	@ModelAttribute("/allMainCatgs")
	public String getAllMainCatgs(ModelMap model) {
		List<ORSMainCategories> allMainCatgs = subcatgsService.getAllMainCatgs();
		model.addAttribute("allMainCatgs", allMainCatgs);
		return "addSubCatgs";

	}

	@ModelAttribute("alphabetOrder")
	public Map<String, String> getAlphabetOrder() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 65; i <= 90; i++) {
			map.put(Character.toString((char) i), Character.toString((char) i));
		}
		return map;
	}
	
	@RequestMapping(value="/deleteSubCatg",method=RequestMethod.GET)
	public ModelAndView deleteSubCatg(@RequestParam Integer id,ModelAndView model){
		System.out.println(id);
		subcatgsService.deleteSubCatg(id);
		model.setViewName("displaySubCatgs");
		return model;
	}
	
	@RequestMapping(value="/editSubCatg",method=RequestMethod.GET)
	public ModelAndView editSubCatg(@RequestParam Integer id,ModelAndView model){
		ORSSubCategories subCatg=subcatgsService.getSubCatg(id);
		model.addObject("subcatg", subCatg);
		model.setViewName("addSubCatgs");
		
		return model;
	}

}