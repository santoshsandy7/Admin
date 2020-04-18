package com.ors.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="ors_main_categories")
public class ORSMainCategories implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ors_mc_id;
	private String ors_mc_category_name;
	@Column(columnDefinition="text")
	private String ors_mc_create_date;
	private String ors_mc_status;
	private String ors_order;
	
	// in orsMainCategories.java
	@OneToMany(mappedBy ="orsMainCategories")
	private List<ORSSubCategories> orsSubCategories;

	@OneToMany(mappedBy="orsMainCategories")
	private List<ORSProducts> orsProduct;

	public Integer getOrs_mc_id() {
		return ors_mc_id;
	}

	public void setOrs_mc_id(Integer ors_mc_id) {
		this.ors_mc_id = ors_mc_id;
	}

	public String getOrs_mc_category_name() {
		return ors_mc_category_name;
	}

	public void setOrs_mc_category_name(String ors_mc_category_name) {
		this.ors_mc_category_name = ors_mc_category_name;
	}

	public String getOrs_mc_create_date() {
		return ors_mc_create_date;
	}

	public void setOrs_mc_create_date(String ors_mc_create_date) {
		this.ors_mc_create_date = ors_mc_create_date;
	}

	public String getOrs_mc_status() {
		return ors_mc_status;
	}

	public void setOrs_mc_status(String ors_mc_status) {
		this.ors_mc_status = ors_mc_status;
	}

	public String getOrs_order() {
		return ors_order;
	}

	public void setOrs_order(String ors_order) {
		this.ors_order = ors_order;
	}

	public List<ORSSubCategories> getOrsSubCategories() {
		return orsSubCategories;
	}

	public void setOrsSubCategories(List<ORSSubCategories> orsSubCategories) {
		this.orsSubCategories = orsSubCategories;
	}

	public List<ORSProducts> getOrsProduct() {
		return orsProduct;
	}

	public void setOrsProduct(List<ORSProducts> orsProduct) {
		this.orsProduct = orsProduct;
	}


		
	
}
