package com.amusementBookingApplication.Contoller;

import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amusementBookingApplication.Entity.Activity;
import com.amusementBookingApplication.Entity.Admin;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.LoginRequest;
import com.amusementBookingApplication.Service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class IAdminController {
	
	@Autowired
	private AdminServiceImpl adminService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/insertAdmin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody LoginRequest d) {
		logger.info("Sending request to Add admin");
		Admin a1 =  adminService.saveAdmin(d);
		logger.info("Admin Added");
		return new ResponseEntity<>(a1,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Admin>deleteAdmin(@PathVariable int id){
		logger.info("Sending request to Delete admin");
		Admin returnAdmin = adminService.delete(id); 
		logger.info("Admin Deleted");
		return new ResponseEntity<>(returnAdmin,HttpStatus.OK);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody LoginRequest d) {
		logger.info("Sending request to update admin");
		Admin ad = adminService.update(d);
		logger.info("Admin Updated");
		return new ResponseEntity<>(ad,HttpStatus.OK);
	}
	
	@GetMapping("/allActivities/{id}")
	public ResponseEntity<List<Activity>> getAllActivities(@PathVariable int id) {
		logger.info("Getting All Activities By CustomerId");
		List<Activity> activities= adminService.getAllActivities(id);
		logger.info("Activities List Received");
		return new ResponseEntity<>(activities,HttpStatus.OK);
	}
	
	@GetMapping("/dateWiseActivities/")
	public ResponseEntity<List<Activity>> getDateWise(){
		List<Activity> activities= adminService.getDateWiseActivities();
		return new ResponseEntity<>(activities,HttpStatus.OK);
	}
	
	@GetMapping("/getAllActivitiesForDays")
	public ResponseEntity<List<Activity>> getAllActivitiesForDays(@RequestParam int cId,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,@DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate) throws CustomerNotFoundException, TicketNotFoundException{
		logger.info("Getting All Activities from start date to end date");
		List<Activity> l1 = adminService.getAllForDays(cId,fromDate,toDate);
		logger.info("Activities recieved");
		return new ResponseEntity<>(l1,HttpStatus.OK);
	}
	
	@GetMapping("/getAllActivities")
	public ResponseEntity<Iterable<Activity>> getAllActivities() {
		logger.info("Getting All Activities ");
		Iterable<Activity> l1 = adminService.getAll();
		logger.info("Activities recieved");
		return new ResponseEntity<>(l1,HttpStatus.OK);
	}
	
	@GetMapping("/customerWiseActivities/")
	public ResponseEntity<List<Activity>> getCustomerWise(){
		List<Activity> activities= adminService.getCustomerWiseActivities();
		return new ResponseEntity<>(activities,HttpStatus.OK);
	}

}


