package com.ors.service;

import java.util.List;

import com.ors.entity.ORSMainCategories;

public interface MainCategoriesService {

	public void addMainCatgs(ORSMainCategories mainCatg);
	
	public ORSMainCategories updateCatgs(ORSMainCategories mainCatg);
	public List<ORSMainCategories> getAllMainCatgs();
	
	public void deleteMainCatg(int mainCatgsId);
	
	public ORSMainCategories getMainCatg(int id);
}
