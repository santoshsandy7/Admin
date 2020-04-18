package com.ors.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ors.dao.MainCategoriesDao;
import com.ors.entity.ORSMainCategories;

@Service
@Transactional
public class MainCategoriesServiceImpl implements MainCategoriesService{

	@Autowired
	private MainCategoriesDao mainCatgDao;
	


	public void addMainCatgs(ORSMainCategories mainCatg) {
		System.out.println("MainCategoriesServiceImpl");
		mainCatgDao.addMainCategories(mainCatg);
	}
	
	public List<ORSMainCategories> getAllMainCatgs() {
		return mainCatgDao.getMainCatgs();
	}
	
	public void deleteMainCatg(int mainCatgsId) {
		mainCatgDao.deleteMainCatg(mainCatgsId);
	}
	
	public MainCategoriesDao getMainCatgDao() {
		return mainCatgDao;
	}

	public void setMainCatgDao(MainCategoriesDao mainCatgDao) {
		this.mainCatgDao = mainCatgDao;
	}

	public ORSMainCategories getMainCatg(int id) {
		
		return mainCatgDao.getMainCatg(id);
	}

	public ORSMainCategories updateCatgs(ORSMainCategories mainCatg) {
		return  mainCatgDao.updateMainCatg(mainCatg);
	}

	

}
