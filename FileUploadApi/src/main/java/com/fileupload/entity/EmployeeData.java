package com.fileupload.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "Employee")
public class EmployeeData {
	
	@Id
	@Column(name = "empID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long empID;
	
	@Column(name = "Empfirst_name")
	public String firstName;
	
	@Column(name = "Emplast_name")
	public String lastName;
	
	@Column(name = "company_name")
	public String companyName;
	
	@Column(name = "Department")
	public String Departement;
	
	@Column(name = "City")
	public String city;
	
	@Column(name = "Country")
	public String country;

	public long getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDepartement() {
		return Departement;
	}

	public void setDepartement(String departement) {
		Departement = departement;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	public EmployeeData(int empID, String firstName, String lastName, String companyName, String departement,
			String city, String country) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.companyName = companyName;
		Departement = departement;
		this.city = city;
		this.country = country;
	}

	public EmployeeData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeData [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + ", companyName="
				+ companyName + ", Departement=" + Departement + ", city=" + city + ", country=" + country + "]";
	}
	
	
	
	
}
