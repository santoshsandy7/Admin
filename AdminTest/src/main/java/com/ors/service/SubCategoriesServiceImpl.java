package com.ors.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ors.dao.SubCategoriesDAO;
import com.ors.entity.ORSMainCategories;
import com.ors.entity.ORSSubCategories;
@Service
@Transactional
public class SubCategoriesServiceImpl implements SubCategoriesService{

	@Autowired
	private SubCategoriesDAO subCatgsdao;
	
	public List<ORSMainCategories> getAllMainCatgs() {
		return subCatgsdao.getAllMainCatgs();
	}

	public void addSubCatgs(ORSSubCategories subCatg) {
		 subCatgsdao.addSubCatgs(subCatg);
	}

	public List<ORSSubCategories> getAllSubCatgs() {
		
		return subCatgsdao.getAllSubCatgs();
	}

	public void deleteSubCatg(Integer id) {
		subCatgsdao.deleteSubCatg(id);
		
	}

	public ORSSubCategories getSubCatg(Integer id) {
		// TODO Auto-generated method stub
		return subCatgsdao.getSubCatg(id);
	}

	public ORSSubCategories updateSubCatg(ORSSubCategories subCatg) {
		return subCatgsdao.updateSubCatg(subCatg);
	}

}
