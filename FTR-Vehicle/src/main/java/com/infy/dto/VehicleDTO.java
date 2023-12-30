package com.infy.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.infy.entity.Vehicle;

public class VehicleDTO {
	@Pattern(regexp="^[A-Za-z]{2}[0-9]{4}$", message="{{invalid.data}}")
	String vehicleNumber;
	@Pattern(regexp="Tower crane|FirePlace Crane|Double treadwheel Crane|Crawler Crane|Aerial Crane|Deck Crane")
	String vehicleName;
	@Min(1)
	Double maxLiftingCapacity;
	@Future
	@JsonFormat(pattern="dd-MM-yyyy")
	Date retireDate;
	@Pattern(regexp="Active|Retired|InProgress")
	String vehicleStatus;
	@Pattern(regexp="^[A-Za-z]{5,25}$")
	String harborLocation;
	@Pattern(regexp="^[A-Za-z]{5,25}$")
	String country;
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public Double getMaxLiftingCapacity() {
		return maxLiftingCapacity;
	}
	public Date getRetireDate() {
		return retireDate;
	}
	public String getVehicleStatus() {
		return vehicleStatus;
	}
	public String getHarborLocation() {
		return harborLocation;
	}
	public String getCountry() {
		return country;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public void setMaxLiftingCapacity(Double maxLiftingCapacity) {
		this.maxLiftingCapacity = maxLiftingCapacity;
	}
	public void setRetireDate(Date retireDate) {
		this.retireDate = retireDate;
	}
	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}
	public void setHarborLocation(String harborLocation) {
		this.harborLocation = harborLocation;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public VehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Vehicle toEntity(VehicleDTO v) {
		return new Vehicle(v.getVehicleNumber(),v.getVehicleName(),v.getMaxLiftingCapacity(),v.getRetireDate(),v.getVehicleStatus(),v.getHarborLocation(),v.getCountry());
	}
	public VehicleDTO(String vehicleNumber, String vehicleName, Double maxLiftingCapacity, Date retireDate,
			String vehicleStatus, String harborLocation, String country) {
		super();
		this.vehicleNumber = vehicleNumber;
		this.vehicleName = vehicleName;
		this.maxLiftingCapacity = maxLiftingCapacity;
		this.retireDate = retireDate;
		this.vehicleStatus = vehicleStatus;
		this.harborLocation = harborLocation;
		this.country = country;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleNumber=" + vehicleNumber + ", vehicleName=" + vehicleName + ", maxLiftingCapacity="
				+ maxLiftingCapacity + ", retireDate=" + retireDate + ", vehicleStatus=" + vehicleStatus
				+ ", harborLocation=" + harborLocation + ", country=" + country + "]";
	}
	
	

}
