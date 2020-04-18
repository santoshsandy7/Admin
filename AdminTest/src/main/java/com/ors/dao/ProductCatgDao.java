package com.ors.dao;

import java.util.List;

import com.ors.entity.ORSProducts;
import com.ors.entity.ORSSubCategories;

public interface ProductCatgDao {

	public List<ORSSubCategories> getRelatedSubCatgs(int subCatgId);

	public void addProduct(ORSProducts orsPrd);

	public List<ORSProducts> getAllProducts();

	public void deleteProducts(Integer id);

	public ORSProducts getProdById(Integer id);

	public ORSProducts updateProduct(ORSProducts orsPrd);
	
	public List<ORSProducts> getProductName(String request);
	public List<ORSProducts> getProductCatNo(String request);
}
