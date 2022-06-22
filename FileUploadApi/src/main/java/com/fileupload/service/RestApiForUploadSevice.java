package com.fileupload.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.dao.IExcelImportToDB;
import com.fileupload.dto.EmployeeDto;
import com.fileupload.entity.EmployeeData;
import com.fileupload.modelObj.Employee;

@Component
public class RestApiForUploadSevice {

	@Autowired
	private IExcelImportToDB excelImport;

	public List<Employee> importExcelFile(MultipartFile files) throws IOException {
		

		System.out.println("entered into importExcelFile");
		List<Employee> employees = new ArrayList<>();
		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		// Read employee data form excel file sheet1.
		int count = 0;
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {
				XSSFRow row = worksheet.getRow(index);
				System.err.println("entered in to for loop");
				Employee employee = new Employee();

				employee.firstName = getCellValue(row, 0);
				employee.lastName = getCellValue(row, 1);
				employee.companyName = getCellValue(row, 2);
				employee.Departement = getCellValue(row, 3);
				employee.city = getCellValue(row, 4);
				employee.country = getCellValue(row, 5);
				employees.add(employee);
				count++;
				System.err.println("entered in to for loop" + count);

			}
		}
		// Save to db.

		List<EmployeeData> entities = new ArrayList<>();
		if (employees.size() > 0) {
			employees.forEach(x -> {

				EmployeeData empData = new EmployeeData();
				empData.firstName = x.firstName;
				empData.lastName = x.lastName;
				empData.companyName = x.companyName;
				empData.Departement = x.Departement;
				empData.city = x.city;
				empData.country = x.country;
				entities.add(empData);
			});
			excelImport.saveAll(entities);
		}
		
		return employees;
	}
	
	private String getCellValue(Row row, int cellNo) {
		DataFormatter formatter = new DataFormatter();
		Cell cell = row.getCell(cellNo);
		return formatter.formatCellValue(cell);
	}

	public Optional<EmployeeData> getDataById(long id) {
		
		
		Optional<EmployeeData> dataById = excelImport.findById(id);
		
		return dataById;
	}

	public List<EmployeeData> getData() {
		
		
		List<EmployeeData> list = excelImport.findAll();
		
		return list;
		
	}
	
	public void uploadData(Employee empDto) {
		
		List<EmployeeData> entities = new ArrayList<>();
		/*
		 * empDto.getEmp().forEach(x -> {
		 * 
		 * EmployeeData empData = new EmployeeData();
		 * empData.setFirstName(x.getFirstName()); empData.setLastName(x.getLastName());
		 * empData.setCompanyName(x.getCompanyName());
		 * empData.setDepartement(x.getDepartement()); empData.setCity(x.getCity());
		 * empData.setCountry(x.getCountry()); entities.add(empData); });
		 */
		
		/* List<EmployeeData> Savedlist = excelImport.saveAll(entities); */
		
		for (int i = 0;i<1000;i++) {
			
			EmployeeData empData = new EmployeeData();
			empData.setFirstName("empData - "+i);
			empData.setLastName("empData - "+i);
			empData.setCompanyName("empData - "+i);
			empData.setDepartement("empData - "+i);
			empData.setCity("empData - "+i);
			empData.setCountry("empData - "+i);
			entities.add(empData);
		}
		
		excelImport.saveAll(entities);
		
		
	}

}
