
package com.ors.dao;

import java.util.List;

import com.ors.entity.ORSMainCategories;

public interface MainCategoriesDao {

	public void addMainCategories(ORSMainCategories mainCatg);
	public ORSMainCategories updateMainCatg(ORSMainCategories mainCatg);
	public List<ORSMainCategories> getMainCatgs();

	public void deleteMainCatg(int mainCatgsId);
	public ORSMainCategories getMainCatg(int mainCatgId);
}
