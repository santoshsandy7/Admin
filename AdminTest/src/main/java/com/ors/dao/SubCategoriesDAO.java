package com.ors.dao;

import java.util.List;

import com.ors.entity.ORSMainCategories;
import com.ors.entity.ORSSubCategories;

public interface SubCategoriesDAO {
	
	public List<ORSMainCategories> getAllMainCatgs();

	public void addSubCatgs(ORSSubCategories subCatg);

	public List<ORSSubCategories> getAllSubCatgs();

	public void deleteSubCatg(Integer id);

	public ORSSubCategories getSubCatg(Integer id);

	public ORSSubCategories updateSubCatg(ORSSubCategories subCatg);
}
