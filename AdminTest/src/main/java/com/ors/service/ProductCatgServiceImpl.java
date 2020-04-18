package com.ors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ors.dao.ProductCatgDao;
import com.ors.entity.ORSProducts;
import com.ors.entity.ORSSubCategories;

@Service
@Transactional
public class ProductCatgServiceImpl implements ProductCatgService {

	@Autowired
	private ProductCatgDao prodCatgDao;

	public List<ORSSubCategories> getRelatedSubCatgs(int subCatgId) {
		return prodCatgDao.getRelatedSubCatgs(subCatgId);
	}

	public void addProducts(ORSProducts orsPrd) {
		prodCatgDao.addProduct(orsPrd);
	}

	public List<ORSProducts> getAllProducts() {
		return prodCatgDao.getAllProducts();
	}

	public void deleteprods(Integer id) {
		prodCatgDao.deleteProducts(id);
	}

	public ORSProducts getProdById(Integer id) {
		// TODO Auto-generated method stub
		return prodCatgDao.getProdById(id);
	}

	public ORSProducts updateproducts(ORSProducts orsPrd) {
		
		return prodCatgDao.updateProduct(orsPrd);
	}

	public List<ORSProducts> searchAutoComplete(String request) {
		return prodCatgDao.getProductName(request);
	}

	public List<ORSProducts> getProductCatNo(String tagName) {
		// TODO Auto-generated method stub
		return prodCatgDao.getProductCatNo(tagName);
	}

}
