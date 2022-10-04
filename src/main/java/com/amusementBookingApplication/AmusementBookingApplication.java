package com.amusementBookingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;



@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="AmusementPark",version="1.0",description="An API used for Amusement-Park-Booking Delivery."))
public class AmusementBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmusementBookingApplication.class, args);
	}

}
