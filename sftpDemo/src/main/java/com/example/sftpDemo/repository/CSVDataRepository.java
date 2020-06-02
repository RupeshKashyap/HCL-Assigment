package com.example.sftpDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sftpDemo.model.CSVData;

@Repository
public interface CSVDataRepository  extends JpaRepository<CSVData, Integer>{

}
