package com.infy.dto;

public class WorkitemVehicleDTO {
	String vehicleNumber;
	String workItemId;
	String workItemStatus;
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getWorkItemId() {
		return workItemId;
	}
	public String getWorkItemStatus() {
		return workItemStatus;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public void setWorkItemId(String workItemId) {
		this.workItemId = workItemId;
	}
	public void setWorkItemStatus(String workItemStatus) {
		this.workItemStatus = workItemStatus;
	}
	public WorkitemVehicleDTO() {
		// TODO Auto-generated constructor stub
	}
}
