package com.fileupload.dto;

import java.util.List;

import com.fileupload.entity.EmployeeData;


public class EmployeeDto {
	
	private List<EmployeeData> emp;

	public List<EmployeeData> getEmp() {
		return emp;
	}

	public void setEmp(List<EmployeeData> emp) {
		this.emp = emp;
	}

}
