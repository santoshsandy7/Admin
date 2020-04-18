package com.ors.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ors_sub_categories")
public class ORSSubCategories {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer ors_sub_id;
	private String ors_sub_category_name;
	@Column(columnDefinition="text")
	private String ors_sub_create_date;
	private String ors_sub_status;
	private String ors_sub_order;
	
	public String getOrs_sub_order() {
		return ors_sub_order;
	}

	

	public void setOrs_sub_order(String ors_sub_order) {
		this.ors_sub_order = ors_sub_order;
	}

	// in  orsSubCategories.java
	@ManyToOne
	@JoinColumn(name = "ors_mc_id")
	private ORSMainCategories orsMainCategories;
	
	@OneToMany(mappedBy ="orsSubCategories")
	private List<ORSProducts> orsProducts;





	public Integer getOrs_sub_id() {
		return ors_sub_id;
	}

	public void setOrs_sub_id(Integer ors_sub_id) {
		this.ors_sub_id = ors_sub_id;
	}



	public String getOrs_sub_category_name() {
		return ors_sub_category_name;
	}

	public void setOrs_sub_category_name(String ors_sub_category_name) {
		this.ors_sub_category_name = ors_sub_category_name;
	}

	public String getOrs_sub_create_date() {
		return ors_sub_create_date;
	}

	public void setOrs_sub_create_date(String ors_sub_create_date) {
		this.ors_sub_create_date = ors_sub_create_date;
	}

	public String getOrs_sub_status() {
		return ors_sub_status;
	}

	public void setOrs_sub_status(String ors_sub_status) {
		this.ors_sub_status = ors_sub_status;
	}

	public ORSMainCategories getOrsMainCategories() {
		return orsMainCategories;
	}

	public void setOrsMainCategories(ORSMainCategories orsMainCategories) {
		this.orsMainCategories = orsMainCategories;
	}

	public List<ORSProducts> getOrsProducts() {
		return orsProducts;
	}

	public void setOrsProducts(List<ORSProducts> orsProducts) {
		this.orsProducts = orsProducts;
	}
	
	
	
	
}
