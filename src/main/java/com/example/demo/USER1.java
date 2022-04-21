package com.example.demo;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLInsert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties("hibernateLazyInitializer")
@Entity
public class USER1 {
	@Id
	private int id;
	private String name;
	private int age;
	private String email;
	private String gender;
	private String medname1,medname2,medname3,medname4,medname5;
	private int med1qty,med2qty,med3qty,med4qty,med5qty;
	public int getMed1qty() {
		return med1qty;
	}
	public void setMed1qty(int med1qty) {
		this.med1qty = med1qty;
	}
	public int getMed2qty() {
		return med2qty;
	}
	public void setMed2qty(int med2qty) {
		this.med2qty = med2qty;
	}
	public int getMed3qty() {
		return med3qty;
	}
	public void setMed3qty(int med3qty) {
		this.med3qty = med3qty;
	}
	public int getMed4qty() {
		return med4qty;
	}
	public void setMed4qty(int med4qty) {
		this.med4qty = med4qty;
	}
	public int getMed5qty() {
		return med5qty;
	}
	public void setMed5qty(int med5qty) {
		this.med5qty = med5qty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMedname1() {
		return medname1;
	}
	public void setMedname1(String medname1) {
		this.medname1 = medname1;
	}
	public String getMedname2() {
		return medname2;
	}
	public void setMedname2(String medname2) {
		this.medname2 = medname2;
	}
	public String getMedname3() {
		return medname3;
	}
	public void setMedname3(String medname3) {
		this.medname3 = medname3;
	}
	public String getMedname4() {
		return medname4;
	}
	public void setMedname4(String medname4) {
		this.medname4 = medname4;
	}
	public String getMedname5() {
		return medname5;
	}
	public void setMedname5(String medname5) {
		this.medname5 = medname5;
	}
	@Override
	public String toString() {
		return "USER1 [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", gender=" + gender
				+ ", medname1=" + medname1 + ", medname2=" + medname2 + ", medname3=" + medname3 + ", medname4="
				+ medname4 + ", medname5=" + medname5 + ", med1qty=" + med1qty + ", med2qty=" + med2qty + ", med3qty="
				+ med3qty + ", med4qty=" + med4qty + ", med5qty=" + med5qty + "]";
	}
}