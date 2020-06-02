package com.example.sftpDemo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.sftpDemo.model.CSVData;
import com.example.sftpDemo.repository.CSVDataRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
public class CSVDataService {
	@Autowired 
	CSVDataRepository csvDataRepository;
	
	public void save(String path) throws IOException {
		
		File f = new File (path);
		
		MultipartFile  file = (MultipartFile) ResourceUtils.getFile(f.getAbsolutePath());
    	Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		
		 // create csv bean reader
        CsvToBean<CSVData> csvToBean = new CsvToBeanBuilder(reader)
                .withType(CSVData.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        
        // convert `CsvToBean` object to list of users
        List<CSVData> csvData = csvToBean.parse();
        csvDataRepository.saveAll(csvToBean);
	}
	
}
