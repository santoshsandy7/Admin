package com.ors.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ors_products")
public class ORSProducts {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ors_prds_id;
	private String ors_prds_cat_no;
	private String ors_prds_orderBy;
	@Column(columnDefinition = "varchar(255) default 'contact us'")
	private String ors_prds_avalibility;
	private Integer ors_prds_status;
	private String ors_prds_pack_size;
	private String ors_prds_make;
	private String ors_prds_desc;
	private String ors_prds_synonyms;
	private String ors_prds_grade;
	private String ors_prds_cas_no;
	@Column(columnDefinition="text")
	private String ors_prds_createDate;

	@ManyToOne
	@JoinColumn(name = "ors_sub_id")
	private ORSSubCategories orsSubCategories;
	
	@ManyToOne
	@JoinColumn(name = "ors_main_id")
	private ORSMainCategories orsMainCategories;



	public Integer getOrs_prds_id() {
		return ors_prds_id;
	}

	public String getOrs_prds_cat_no() {
		return ors_prds_cat_no;
	}

	public void setOrs_prds_cat_no(String ors_prds_cat_no) {
		this.ors_prds_cat_no = ors_prds_cat_no;
	}



	public String getOrs_prds_orderBy() {
		return ors_prds_orderBy;
	}

	public void setOrs_prds_orderBy(String ors_prds_orderBy) {
		this.ors_prds_orderBy = ors_prds_orderBy;
	}

	public String getOrs_prds_avalibility() {
		return ors_prds_avalibility;
	}

	public void setOrs_prds_avalibility(String ors_prds_avalibility) {
		this.ors_prds_avalibility = ors_prds_avalibility;
	}

	public Integer getOrs_prds_status() {
		return ors_prds_status;
	}

	public void setOrs_prds_status(Integer ors_prds_status) {
		this.ors_prds_status = ors_prds_status;
	}

	public String getOrs_prds_make() {
		return ors_prds_make;
	}

	public void setOrs_prds_make(String ors_prds_make) {
		this.ors_prds_make = ors_prds_make;
	}

	

	public String getOrs_prds_desc() {
		return ors_prds_desc;
	}

	public void setOrs_prds_desc(String ors_prds_desc) {
		this.ors_prds_desc = ors_prds_desc;
	}

	public String getOrs_prds_createDate() {
		return ors_prds_createDate;
	}

	public void setOrs_prds_createDate(String ors_prds_createDate) {
		this.ors_prds_createDate = ors_prds_createDate;
	}

	public ORSSubCategories getOrsSubCategories() {
		return orsSubCategories;
	}

	public ORSMainCategories getOrsMainCategories() {
		return orsMainCategories;
	}

	public void setOrsMainCategories(ORSMainCategories orsMainCategories) {
		this.orsMainCategories = orsMainCategories;
	}

	
	public void setOrs_prds_id(Integer ors_prds_id) {
		this.ors_prds_id = ors_prds_id;
	}

	public void setOrsSubCategories(ORSSubCategories orsSubCategories) {
		this.orsSubCategories = orsSubCategories;
	}

	public String getOrs_prds_pack_size() {
		return ors_prds_pack_size;
	}

	public void setOrs_prds_pack_size(String ors_prds_pack_size) {
		this.ors_prds_pack_size = ors_prds_pack_size;
	}

	public String getOrs_prds_synonyms() {
		return ors_prds_synonyms;
	}

	public void setOrs_prds_synonyms(String ors_prds_synonyms) {
		this.ors_prds_synonyms = ors_prds_synonyms;
	}

	public String getOrs_prds_grade() {
		return ors_prds_grade;
	}

	public void setOrs_prds_grade(String ors_prds_grade) {
		this.ors_prds_grade = ors_prds_grade;
	}

	public String getOrs_prds_cas_no() {
		return ors_prds_cas_no;
	}

	public void setOrs_prds_cas_no(String ors_prds_cas_no) {
		this.ors_prds_cas_no = ors_prds_cas_no;
	}

}
