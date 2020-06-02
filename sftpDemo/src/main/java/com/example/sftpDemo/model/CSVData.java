package com.example.sftpDemo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "csv_data")
public class CSVData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;
	
	@Column
	public Date resultTime ;
	
	@Column 
	public Integer granularityPeriod ;
	
	@Column 
	public String objectName;
	
	@Column 
	public Integer cellId;
	
	@Column 
	public Integer callAttampt ;
	
	

	public CSVData(Integer id, Date resultTime, Integer granularityPeriod, String objectName, Integer cellId,
			Integer callAttampt) {
		super();
		this.id = id;
		this.resultTime = resultTime;
		this.granularityPeriod = granularityPeriod;
		this.objectName = objectName;
		this.cellId = cellId;
		this.callAttampt = callAttampt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getResultTime() {
		return resultTime;
	}

	public void setResultTime(Date resultTime) {
		this.resultTime = resultTime;
	}

	public Integer getGranularityPeriod() {
		return granularityPeriod;
	}

	public void setGranularityPeriod(Integer granularityPeriod) {
		this.granularityPeriod = granularityPeriod;
	}

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public Integer getCellId() {
		return cellId;
	}

	public void setCellId(Integer cellId) {
		this.cellId = cellId;
	}

	public Integer getCallAttampt() {
		return callAttampt;
	}

	public void setCallAttampt(Integer callAttampt) {
		this.callAttampt = callAttampt;
	}

	@Override
	public String toString() {
		return "CSVFileData [id=" + id + ", resultTime=" + resultTime + ", granularityPeriod=" + granularityPeriod
				+ ", objectName=" + objectName + ", cellId=" + cellId + ", callAttampt=" + callAttampt + "]";
	}

}
