package com.ssi.entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Property {
	@Id
	private String pcode;
	private String ptype;
	private String owneremail;
	private int price;
	private Blob photo;
	private Blob registry;
	
	public Blob getRegistry() {
		return registry;
	}
	public void setRegistry(Blob registry) {
		this.registry = registry;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getOwneremail() {
		return owneremail;
	}
	public void setOwneremail(String owneremail) {
		this.owneremail = owneremail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setPhoto(Blob photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Property [pcode=" + pcode + ", ptype=" + ptype
				+ ", owneremail=" + owneremail + ", price=" + price
				+ ", photo=" + photo + "]";
	}
	
}


