package com.member.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustVO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public CustVO() {};

	@Id
	@GeneratedValue //自動新增流水號
	@Column(name = "CUST_ID")
	private Integer cust_id;
	
	@Column(name = "CUST_ACCOUNT")
	private String cust_account;
	
	@Column(name = "CUST_PASSWORD")
	private String cust_password;
	
	@Column(name = "CUST_RIGHT")
	private String cust_right;
	
	@Column(name = "CUST_USE")
	private String cust_use;
	
	@Column(name = "CUST_NAME")
	private String cust_name;
	
	@Column(name = "CUST_SEX")
	private String cust_sex;
	
	@Column(name = "CUST_TEL")
	private String cust_tel;
	
	@Column(name = "CUST_EMAIL")
	private String cust_email;
	
	@Column(name = "CUST_IMG")
	private String cust_img;
	
	@Column(name = "CUST_ID_CARD")
	private String cust_id_card;
	
	@Column(name = "CUST_BIRTHDAY")
	private LocalDate cust_birthday;
	
	@Column(name = "CUST_CARD")
	private String cust_card;
	
	@Column(name = "CUST_ADDRESS")
	private String cust_address;

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_account() {
		return cust_account;
	}

	public void setCust_account(String cust_account) {
		this.cust_account = cust_account;
	}

	public String getCust_password() {
		return cust_password;
	}

	public void setCust_password(String cust_password) {
		this.cust_password = cust_password;
	}

	public String getCust_right() {
		return cust_right;
	}

	public void setCust_right(String cust_right) {
		this.cust_right = cust_right;
	}

	public String getCust_use() {
		return cust_use;
	}

	public void setCust_use(String cust_use) {
		this.cust_use = cust_use;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_sex() {
		return cust_sex;
	}

	public void setCust_sex(String cust_sex) {
		this.cust_sex = cust_sex;
	}

	public String getCust_tel() {
		return cust_tel;
	}

	public void setCust_tel(String cust_tel) {
		this.cust_tel = cust_tel;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public String getCust_img() {
		return cust_img;
	}

	public void setCust_img(String cust_img) {
		this.cust_img = cust_img;
	}

	public String getCust_id_card() {
		return cust_id_card;
	}

	public void setCust_id_card(String cust_id_card) {
		this.cust_id_card = cust_id_card;
	}

	public LocalDate getCust_birthday() {
		return cust_birthday;
	}

	public void setCust_birthday(LocalDate cust_birthday) {
		this.cust_birthday = cust_birthday;
	}

	public String getCust_card() {
		return cust_card;
	}

	public void setCust_card(String cust_card) {
		this.cust_card = cust_card;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
