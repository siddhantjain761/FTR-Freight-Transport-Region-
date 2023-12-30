package com.infy.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.infy.dto.WorkitemVehicleDTO;

@FeignClient(name="WorkitemMS")//, url="http://localhost:3502/")
public interface WorkItemsFeign {
	
	@GetMapping("ftr/workItems/managed-vehicle/{vehicleNumber}")
	WorkitemVehicleDTO fetchWorkItemDetailsByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber);	
	
}
