package com.demo.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.demo.entity.Terminal;
 

 
 
public class TerminalDTO{
	@Column(name="terminalId")
	@NotBlank(message="Terminal id is must")
	private String terminalId;
	 
	private String terminalName;
	
	private String country;
	 
	private String itemType;
 
	private String itemDescription;
	@Min(value=1000,message = "capacity should be grater than 1000")
	@Max(value=999999,message="must be less tha 999999")
	private Integer capacity;
	 
	private Integer AvaliableCapicity;
	@Pattern(regexp="Avaliable|UnAvaliable",message="Staus can be Avaliable or Unavaliable")
	private String status;
	@Column(name="harborLocation")
	@NotBlank(message="harbor location cnt be null") 
	private String harborLocation;
	
	@Override
	public String toString() {
		return  "TerminalDetails[Trminal id:"+terminalId+",Ternimal Name:"+terminalName+",country"+country+",item Type:"+itemType+",itemDescription:"+itemDescription+
				 "capacity:"+capacity+",Avaliable Capacity:"+AvaliableCapicity+ "Status:"+status+",Harbor Location:"+harborLocation+"]";
		
	}	
	public TerminalDTO(String terminalId,String terminalName,String country,String itemType,String itemDescription,Integer capacity,String status,
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
	
	
	public TerminalDTO() {
		// TODO Auto-generated constructor stub
		super();
	}
	public static Terminal convertDTOEntity(TerminalDTO dto) {
		Terminal t=new Terminal();
		t.setTerminalId(dto.getTerminalId());
		t.setTerminalName( dto.getTerminalName());
		t.setCountry(dto.getCountry());
		t.setItemType( dto.getItemType());
		t.setItemDescription(dto.getItemDescription());
		t.setCapacity(dto.getCapacity());;
		t.setStatus(dto.getStatus());
		t.setHarborLocation(dto.getHarborLocation());
		t.setAvaliableCapacity(dto.getAvaliableCapicity());
		
		return t;
	} 
	
	// Converts Entity into DTO
		public static TerminalDTO valueOf(Terminal terminal) {
			TerminalDTO terminalDTO=new TerminalDTO();
			terminalDTO.setTerminalId(terminal.getTerminalId());
			terminalDTO.setAvaliableCapicity(terminal.getAvaliableCapicity());
			terminalDTO.setCapacity(terminal.getCapacity());
			terminalDTO.setCountry(terminal.getCountry());
			terminalDTO.setHarborLocation(terminal.getHarborLocation());
			terminalDTO.setItemDescription(terminal.getItemDescription());
			terminalDTO.setItemType(terminal.getItemType());
			terminalDTO.setStatus(terminal.getStatus());
			terminalDTO.setTerminalName(terminal.getTerminalName());
			return terminalDTO;
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
	public void setAvaliableCapicity(Integer avaliableCapicity) {
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
