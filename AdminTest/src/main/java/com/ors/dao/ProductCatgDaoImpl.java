package com.ors.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ors.entity.ORSProducts;
import com.ors.entity.ORSSubCategories;
@Repository
public class ProductCatgDaoImpl implements ProductCatgDao {
	
	@Autowired
	private SessionFactory sf;
	
	@SuppressWarnings("unchecked")
	public List<ORSSubCategories> getRelatedSubCatgs(int subCatgId) {
		
		return sf.getCurrentSession().createQuery("from ORSSubCategories where ors_mc_id=:mainId").setParameter("mainId", subCatgId).list();
	}

	public void addProduct(ORSProducts orsPrd) {
		sf.getCurrentSession().saveOrUpdate(orsPrd);
	}

	public List<ORSProducts> getAllProducts() {
		return sf.getCurrentSession().createQuery("from ORSProducts").list();
	}

	public void deleteProducts(Integer id) {
		ORSProducts prd= (ORSProducts) sf.getCurrentSession().load(ORSProducts.class, id);
		if(prd!=null){
			this.sf.getCurrentSession().delete(prd);
		}
	}

	public ORSProducts getProdById(Integer id) {
		return (ORSProducts) sf.getCurrentSession().get(ORSProducts.class, id);
		
	}

	public ORSProducts updateProduct(ORSProducts orsPrd) {
		sf.getCurrentSession().update(orsPrd);
		return orsPrd;
	}

	public List<ORSProducts> getProductName(String request) {
		return sf.getCurrentSession().createQuery("from ORSProducts where ors_prds_desc like concat('%',:studentName,'%')").setParameter("studentName",request).list();
	}

	public List<ORSProducts> getProductCatNo(String request) {
		 return sf.getCurrentSession().createQuery("from ORSProducts where ors_prds_cat_no like concat('%',:studentName,'%')").setParameter("studentName",request).list();
	}

}
