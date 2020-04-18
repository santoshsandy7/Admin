package com.ors.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ors.entity.ORSMainCategories;
import com.ors.entity.ORSProducts;
import com.ors.entity.ORSSubCategories;
import com.ors.service.ProductCatgService;
import com.ors.service.SubCategoriesService;

@RestController
@RequestMapping("/admin/*")
public class ProductController {

	@Autowired
	private SubCategoriesService subcatgsService;

	@Autowired
	private ProductCatgService prdCatgService;

	// productCatgs
	@RequestMapping(value = "/productCatgs", method = RequestMethod.GET)
	public ModelAndView displayAllProducts(ModelAndView model) {
		List<ORSProducts> prods = prdCatgService.getAllProducts();
		model.addObject("prods", prods);
		model.setViewName("displayProdsCatg");
		return model;
	}

	@RequestMapping(value = "/addProducts", method = RequestMethod.GET)
	public ModelAndView addProducts(ModelAndView model) {
		ORSProducts prod = new ORSProducts();
		model.addObject("prod", prod);
		model.setViewName("addProducts");
		return model;
	}

	@ModelAttribute("/allMainCatgs")
	public String getAllMainCatgs(ModelMap model) {
		List<ORSMainCategories> allMainCatgs = subcatgsService.getAllMainCatgs();
		model.addAttribute("allMainCatgs", allMainCatgs);
		return "addProducts";

	}

	@RequestMapping(value = "/getSubCatgByCatg", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<Integer, String> getSubCatgByCatg(@RequestParam Integer subCatgId, ModelMap model) {
		List<ORSSubCategories> subCatgs = prdCatgService.getRelatedSubCatgs(subCatgId);
		Map<Integer, String> studentsMap = new HashMap<Integer, String>();
		for (ORSSubCategories student : subCatgs) {
			studentsMap.put(student.getOrs_sub_id(), student.getOrs_sub_category_name());
		}
		return studentsMap;
	}

	@ModelAttribute("alphabetOrder")
	public Map<String, String> getAlphabetOrder() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (int i = 65; i <= 90; i++) {
			map.put(Character.toString((char) i), Character.toString((char) i));
		}
		return map;
	}

	@RequestMapping(value = "/saveProducts", method = RequestMethod.POST)
	public ModelAndView saveProductCatg(@ModelAttribute ORSProducts orsPrd, @RequestParam Integer ors_sub_id) {
		if (orsPrd.getOrs_prds_id() == null) {
			ORSSubCategories subCatg = new ORSSubCategories();
			subCatg.setOrs_sub_id(ors_sub_id);
			orsPrd.setOrsSubCategories(subCatg);
			orsPrd.setOrs_prds_createDate(dateAndTime());
			orsPrd.setOrs_prds_status(1);
			prdCatgService.addProducts(orsPrd);
		}else{
			
			System.out.println("Sub Catg"+ors_sub_id);
			System.out.println(orsPrd.getOrs_prds_id());
			ORSSubCategories subCatg = new ORSSubCategories();
			subCatg.setOrs_sub_id(ors_sub_id);
			orsPrd.setOrsSubCategories(subCatg);
			orsPrd.setOrs_prds_createDate(dateAndTime());
			orsPrd.setOrs_prds_status(1);
			prdCatgService.updateproducts(orsPrd);
		}

		return new ModelAndView("redirect:/admin/productCatgs");
	}

	public String dateAndTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return formatter.format(date);
	}

	@RequestMapping(value = "/deleteProd", method = RequestMethod.GET)
	public ModelAndView deleteProds(@RequestParam Integer id) {
		prdCatgService.deleteprods(id);

		return new ModelAndView("redirect:/admin/productCatgs");

	}
	
	@RequestMapping(value = "/searchByName", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Map<Integer, String> searchAutoComplete(@RequestParam String tagName, ModelAndView model) {
		List<ORSProducts> subCatgs = prdCatgService.searchAutoComplete(tagName);
		Map<Integer, String> studentsMap = new HashMap<Integer, String>();
		for (ORSProducts student : subCatgs) {
			studentsMap.put(student.getOrs_prds_id(), student.getOrs_prds_desc().toString());
		}
	
		if(studentsMap.isEmpty()){
			List<ORSProducts> subCatgs1 = prdCatgService.getProductCatNo(tagName);
			for (ORSProducts student : subCatgs1) {
				studentsMap.put(student.getOrs_prds_id(), student.getOrs_prds_cat_no().toString());
			}
		}
		
		return studentsMap;
	}

	@RequestMapping(value = "/editProd", method = RequestMethod.GET)
	public ModelAndView editProds(@RequestParam Integer id, ModelAndView model) {
		ORSProducts prds = prdCatgService.getProdById(id);
		model.addObject("prod", prds);
		model.setViewName("addProducts");
		return model;
	}
	
}
