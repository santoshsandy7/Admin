package com.ors.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ors.entity.ORSMainCategories;


@Repository
public class MainCategoriesDAOImpl implements MainCategoriesDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addMainCategories(ORSMainCategories mainCatg) {
		System.out.println("MainCategoriesDAOImpl");
		sessionFactory.getCurrentSession().saveOrUpdate(mainCatg);
	}

	public List<ORSMainCategories> getMainCatgs() {
		return sessionFactory.getCurrentSession().createQuery("from ORSMainCategories").list();
	}

	public void deleteMainCatg(int mainCatgsId) {
		
		ORSMainCategories mainCatgs= (ORSMainCategories) sessionFactory.getCurrentSession().load(ORSMainCategories.class, mainCatgsId);
		if(mainCatgs!=null){
			this.sessionFactory.getCurrentSession().delete(mainCatgs);
			
		}
	}

	public ORSMainCategories getMainCatg(int mainCatgId) {
		return (ORSMainCategories) sessionFactory.getCurrentSession().get(ORSMainCategories.class, mainCatgId);
	}

	public ORSMainCategories updateMainCatg(ORSMainCategories mainCatg) {
		 sessionFactory.getCurrentSession().update(mainCatg);
		 return mainCatg;
		
	}

}
