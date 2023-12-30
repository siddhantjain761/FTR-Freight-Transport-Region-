package com.infy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FtrVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtrVehicleApplication.class, args);
//		ApplicationContext ctx = (ApplicationContext) SpringApplication.run(FtrVehicleApplication.class, args);
//		VehicleService service = (VehicleService) ctx.getBean("vehicleService");
//		Date date= new Date();
//		service.insertNewVehicle(new VehicleDTO("UP85","Activa",2d,date,"true","UP","India"));
		
	}

}
