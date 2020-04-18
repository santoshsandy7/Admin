package com.ors.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ors.entity.ORSMainCategories;
import com.ors.entity.ORSSubCategories;

@Repository
public class SubCategoriesDAOImpl implements SubCategoriesDAO {

	@Autowired
	private SessionFactory sf;

	public List<ORSMainCategories> getAllMainCatgs() {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().createQuery("from ORSMainCategories").list();
	}

	public void addSubCatgs(ORSSubCategories subCatg) {
		
		sf.getCurrentSession().saveOrUpdate(subCatg);
	}

	public List<ORSSubCategories> getAllSubCatgs() {
		return sf.getCurrentSession().createQuery("from ORSSubCategories").list();
	}

	public void deleteSubCatg(Integer id) {
			ORSSubCategories subCatg= (ORSSubCategories) sf.getCurrentSession().load(ORSSubCategories.class, id);
			if(subCatg!=null){
				this.sf.getCurrentSession().delete(subCatg);
			}
	}

	public ORSSubCategories getSubCatg(Integer id) {
		return (ORSSubCategories) sf.getCurrentSession().get(ORSSubCategories.class,id);
	}

	public ORSSubCategories updateSubCatg(ORSSubCategories subCatg) {
		sf.getCurrentSession().update(subCatg);
		return subCatg;
	}

}
