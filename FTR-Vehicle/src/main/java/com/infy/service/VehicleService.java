package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.infy.dto.VehicleDTO;
import com.infy.entity.Vehicle;
import com.infy.exception.VEHICLE_NOT_FOUND_EXCEPTION;
import com.infy.exception.VEHICLE_UPDATE_ALREADY_EXISTS;
import com.infy.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {
	
	@Autowired
	VehicleRepository vr;
	
	public String insertNewVehicle(VehicleDTO vehicleDTO ) throws  MethodArgumentNotValidException{
		Optional<Vehicle> obj1 = vr.findById(vehicleDTO.getVehicleNumber());
		 
			vr.save(VehicleDTO.toEntity(vehicleDTO));
			System.out.println("Inserted");
			return  "new  vehicle recorded successfully Inserted";
		 
	 
		
	}
	public List<VehicleDTO> fetchAvailableVehicles() throws Exception{
		Optional<List<Vehicle>> obj1 = Optional.of(vr.findAll());
		if(obj1.isPresent()) {
			List<Vehicle> li = obj1.get();
			List<VehicleDTO> li2 = new ArrayList<VehicleDTO>();
			System.out.println(li);
			for(Vehicle v : li) {
				System.out.println(v);
				li2.add(Vehicle.toDTO(v));
			}
			return li2;
		}
		else throw new Exception("Invalid Data");
	}
	public List<VehicleDTO> fetchVehicleDetailsByVehicleName(String vehicleName) throws Exception{
		Optional<List<Vehicle>> obj1 = vr.findByVehicleName(vehicleName);
		if(obj1.isPresent()) {
			List<Vehicle> li = obj1.get();
			List<VehicleDTO> li2 = new ArrayList<VehicleDTO>();
			System.out.println(li);
			for(Vehicle v : li) {
				System.out.println(v);
				li2.add(Vehicle.toDTO(v));
			}
			return li2;
		}
		else throw new Exception("Invalid Data");
	}
	public VehicleDTO fetchVehicleDetailsByVehicleNumber(String vehicleNumber) throws Exception{
		Optional<Vehicle> obj1 = vr.findById(vehicleNumber);
		if(obj1.isPresent()) {
			return Vehicle.toDTO(obj1.get());
		}
		else throw new Exception("Invalid Data");
	}
	public String updateVehicleStatus(String vehicleNum,VehicleDTO dto) throws Exception {
		Optional<Vehicle> obj1 = vr.findById(vehicleNum);
		if(obj1.isPresent()) {
			Vehicle obj2 = obj1.get();
			if(!obj2.getVehicleStatus().equalsIgnoreCase(dto.getVehicleStatus())) {
				if (dto.getVehicleStatus().equalsIgnoreCase("Active") || dto.getVehicleStatus().equalsIgnoreCase("Retired") || dto.getVehicleStatus().equalsIgnoreCase("Inprogress") ) {
					obj2.setVehicleStatus(dto.getVehicleStatus());
					return "Vehicle Status successfully changed to :"+dto.getVehicleStatus();
				}
				else throw new Exception("Invalid-data");
			}
			else {
				throw new VEHICLE_UPDATE_ALREADY_EXISTS();
			}
			
		}
		else throw new VEHICLE_NOT_FOUND_EXCEPTION();
	}
	public String removeVehicle(String vehicleNumber) throws Exception{
		Optional<Vehicle> obj1 = vr.findById(vehicleNumber);
		if(obj1.isPresent()) {
			vr.delete(obj1.get());
			return "Vehicle removed successfully";
		}
		else throw new Exception("Invalid Data");
	}
	
	
	

}
