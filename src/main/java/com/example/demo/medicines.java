package com.example.demo;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
public class medicines {
	@Id
	int medid;
	String medname;
	String medtype;
	String substitute;
	Date expdate;
	int cost;
	 int quantity;
	 int agelimit;
	 //@ManyToMany
	 //private List<USER1> user1;
	public int getMedid() {
		return medid;
	}
	public void setMedid(int medid) {
		this.medid = medid;
	}
	public String getMedname() {
		return medname;
	}
	public void setMedname(String medname) {
		this.medname = medname;
	}
	public String getMedtype() {
		return medtype;
	}
	public void setMedtype(String medtype) {
		this.medtype = medtype;
	}
	public String getSubstitute() {
		return substitute;
	}
	public void setSubstitute(String substitute) {
		this.substitute = substitute;
	}
	public Date getExpdate() {
		return expdate;
	}
	public void setExpdate(Date expdate) {
		this.expdate = expdate;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public  int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getAgelimit() {
		return agelimit;
	}
	public void setAgelimit(int agelimit) {
		this.agelimit = agelimit;
	}
	@Override
	public String toString() {
		return "medicines [medid=" + medid + ", medname=" + medname + ", medtype=" + medtype + ", substitute="
				+ substitute + ", expdate=" + expdate + ", cost=" + cost + ", quantity=" + quantity + ", agelimit="
				+ agelimit + "]";
	}

}
