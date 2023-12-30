package com.infy.repository;

import java.util.Optional;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {
	public Optional<List<Vehicle>> findByVehicleName(String vehicleName);

}
