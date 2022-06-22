package com.fileupload.comtroller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileupload.dao.IExcelImportToDB;
import com.fileupload.dto.EmployeeDto;
import com.fileupload.entity.EmployeeData;
import com.fileupload.modelObj.Employee;
import com.fileupload.service.RestApiForUploadSevice;

@RestController
@RequestMapping("/controller")
public class RestApiForUpload {
	
	@Autowired
	private RestApiForUploadSevice uploadService;
	
	@PostMapping("/import")
	public List<Employee> importExcelFile(@RequestParam("file") MultipartFile files)
			throws IOException, InterruptedException {
		
		List<Employee> savedList = uploadService.importExcelFile(files);
		return savedList;
	}

	

	@GetMapping("/allEmpData")
	public List<EmployeeData> getData() {

		
		List<EmployeeData> list = uploadService.getData();
		
		return list;

	}

	@GetMapping("/EmpDataById/{id}")
	public Optional<EmployeeData> getDataById(@PathVariable("id") long id) {

		
		Optional<EmployeeData> dataById = uploadService.getDataById(id);
		

		return dataById;
	}
	
	@PostMapping("/uploadToDb")
	public void uploadData(@RequestBody Employee empDto) {
		
		/* List<EmployeeData> data = uploadService.uploadData(empDto); */
		 uploadService.uploadData(empDto);
		 
		
		
	}

}
