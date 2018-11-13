package com.integration.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author frvazquez
 * @creacion 13/nov/2018
 *
 */
@Document
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String names;
	private String lastnames;
	private String email;
	private String tel;

	public Contact() {

	}

	// GETTERS
	public String getId() {
		return id;
	}

	public String getNames() {
		return names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	// SETTERS
	public void setId(String id) {
		this.id = id;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", names=" + names + ", lastnames=" + lastnames + ", email=" + email + ", tel="
				+ tel + "]";
	}

}
