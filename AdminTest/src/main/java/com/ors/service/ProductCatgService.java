package com.ors.service;

import java.util.List;

import com.ors.entity.ORSMainCategories;
import com.ors.entity.ORSProducts;
import com.ors.entity.ORSSubCategories;


public interface ProductCatgService {

	public  List<ORSSubCategories> getRelatedSubCatgs( int subCatgId);

	public void addProducts(ORSProducts orsPrd);

	public List<ORSProducts> getAllProducts();

	public void deleteprods(Integer id);

	public ORSProducts getProdById(Integer id);

	public ORSProducts updateproducts(ORSProducts orsPrd);
	
	public List<ORSProducts> searchAutoComplete(String request);

	public List<ORSProducts> getProductCatNo(String tagName);
}
