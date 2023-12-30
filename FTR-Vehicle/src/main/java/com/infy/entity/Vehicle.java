package com.infy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.VehicleDTO;

@Entity
@Table(name="ftr_vehicles")
public class Vehicle {
	@Id
	@Column(name="vehicle_number")
	String vehicleNumber;
	@Column(name="vehicle_name")
	String vehicleName;
	@Column(name="max_lifting_capacity")
	Double maxLiftingCapacity;
	@Column(name="retire_date")
	Date retireDate;
	@Column(name="vehicle_status")
	String vehicleStatus;
	@Column(name="harborLocation")
	String harborLocation;
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
	public static VehicleDTO toDTO(Vehicle v) {
		return new VehicleDTO(v.getVehicleNumber(),v.getVehicleName(),v.getMaxLiftingCapacity(),v.getRetireDate(),v.getVehicleStatus(),v.getHarborLocation(),v.getCountry());
	}
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vehicle(String vehicleNumber, String vehicleName, Double maxLiftingCapacity, Date retireDate,
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
