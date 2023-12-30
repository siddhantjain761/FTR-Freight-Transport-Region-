package com.infy.controller;

import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

 
import com.infy.dto.VehicleDTO;
import com.infy.dto.WorkitemVehicleDTO;
import com.infy.service.VehicleService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

 

@Validated
@RestController
public class VehicleController {

	@Autowired
	VehicleService service;
	

	@Autowired
	RestTemplate template;
	
	@Autowired
	WorkItemsFeign wf; 
	
	@PostMapping("/ftr1/vehicles")
	public ResponseEntity<Object>  insertNewVehicle(@RequestBody @Valid  VehicleDTO vehicleDTO) throws  MethodArgumentNotValidException{
		String message= service.insertNewVehicle(vehicleDTO);
		HashMap<String,Object> hm = new HashMap<>();
		hm.put("data",message);
		
		return ResponseEntity.ok(hm);
		
	}
	
	@GetMapping("/ftr/vehicles")
	public ResponseEntity<List<VehicleDTO>> fetchAvailableVehicles() throws Exception{
		List<VehicleDTO> result = service.fetchAvailableVehicles();
		for(VehicleDTO v:result) {
		System.out.println(v);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@PutMapping("ftr/vehicles/{vehicleNumber}")
	public ResponseEntity<String> updateVehicleStatus(@PathVariable @Valid @Pattern(regexp="^[A-Za-z]{2}[0-9]{4}$", message="Invalid data") String vehicleNumber,@RequestBody @Valid VehicleDTO dto) throws Exception{
		String result = service.updateVehicleStatus(vehicleNumber, dto);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@GetMapping("ftr/vehicles/managed-name/{vehicleName}")
	public ResponseEntity<List<VehicleDTO>> fetchVehicleDetailsByVehicleName(@PathVariable String vehicleName) throws Exception{
		List<VehicleDTO> result = service.fetchVehicleDetailsByVehicleName(vehicleName);
		for(VehicleDTO v:result) {
		System.out.println(v);
		}
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
	@CircuitBreaker(name = "", fallbackMethod="deleteFallback")
	@DeleteMapping("ftr/vehicles/{vehicleNumber}")
	public ResponseEntity<String> removeVehicle(@PathVariable String vehicleNumber) throws Exception{
		WorkitemVehicleDTO wdd = wf.fetchWorkItemDetailsByVehicleNumber(vehicleNumber);
		System.out.println("after feign call");
		if(wdd==null || wdd.getWorkItemStatus()=="Completed") {
			String result = service.removeVehicle(vehicleNumber);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		
		else System.out.println("Throwing error now");
		throw new Exception("Vehicle is assigned to incomplete work item");
	}
	public ResponseEntity<String> deleteFallback(String vehicleNumber, Throwable throwable){
		System.out.println("in fallback");
		return new ResponseEntity<>("Could not delete the vehicle WorkItem MS is not up",HttpStatus.OK);
	}	
	@GetMapping("ftr/vehicles/managed-number/{vehicleNumber}")
	public ResponseEntity<VehicleDTO> fetchVehicleDetailsByVehicleNumber(@PathVariable @Valid @Pattern(regexp="^[A-Za-z]{2}[0-9]{4}$" , message="Invalid data") String vehicleNumber) throws Exception{
		System.out.println("in method");
		VehicleDTO result = service.fetchVehicleDetailsByVehicleNumber(vehicleNumber);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
}
