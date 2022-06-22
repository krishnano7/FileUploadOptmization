package com.fileupload.dao;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fileupload.entity.EmployeeData;

@Repository
public interface IExcelImportToDB extends JpaRepository<EmployeeData, Long>{

}
