package com.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="ftr_terminal")
public class Terminal {
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="terminalId")	 
	private String terminalId;
	@Column(name="terminalName") 
	private String terminalName;
	private String country;
	@Column(name="itemType")
	private String itemType;
	@Column(name="itemDescription")
	private String itemDescription;
	 
	private Integer capacity;
	@Column(name="AvaliableCapicity")
	private Integer AvaliableCapicity;
	 
	private String status;
	@Column(name="harborLocation")
	private String harborLocation;
	
	@Override
	public String toString() {
		return  "TerminalDetails[Trminal id:"+terminalId+",Ternimal Name:"+terminalName+",country"+country+",item Type:"+itemType+",itemDescription:"+itemDescription+
				 "capacity:"+capacity+",Avaliable Capacity:"+AvaliableCapicity+ "Status:"+status+",Harbor Location:"+harborLocation+"]";
		
	}	
	public Terminal(String terminalId,String terminalName,String country,String itemType,String itemDescription,Integer capacity,String status,
			String harborLocation,Integer AvaliableCapicity) {
		super();
		this.terminalId=terminalId;
		this.terminalName=terminalName;
		this.country=country;
		this.itemType=itemType;
		this.itemDescription=itemDescription;
		this.capacity=capacity;
		this.status=status;
		this.harborLocation=harborLocation;
		this.AvaliableCapicity=AvaliableCapicity;
	}
	
	public Terminal() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getTerminalName() {
		return terminalName;
	}
	public void setTerminalName(String terminalName) {
		this.terminalName = terminalName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	 
	public Integer getAvaliableCapicity() {
		return AvaliableCapicity;
	}
	public void setAvaliableCapacity(Integer avaliableCapicity) {
		AvaliableCapicity = avaliableCapicity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHarborLocation() {
		return harborLocation;
	}
	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	

}
