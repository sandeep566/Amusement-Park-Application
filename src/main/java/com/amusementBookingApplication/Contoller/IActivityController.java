package com.amusementBookingApplication.Contoller;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amusementBookingApplication.Entity.Activity;
import com.amusementBookingApplication.Service.ActivityServiceImpl;



@RestController
@RequestMapping("/activity")
public class IActivityController {
	
	@Autowired
    private ActivityServiceImpl activityService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/addActivity")
	public ResponseEntity<Activity> addActivity(@RequestBody Activity activity)  {
		logger.info("Sending request to Add a activity");
		Activity ac = activityService.addActivity(activity);
		logger.info("Activity Added");
		return new ResponseEntity<>(ac,HttpStatus.OK);
	} 
	
	
	 @PutMapping("/updateActivity")
	public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity) {
		logger.info("Sending request to update a Activity");
		Activity ac = activityService.updateActivity(activity);
		logger.info("Activity updated");
		return new ResponseEntity<>(ac,HttpStatus.OK);
	} 
	 
	 @DeleteMapping("/deleteActivity/{id}")
	 public ResponseEntity<Activity> deleteActivity(@PathVariable int id) {
		 logger.info("Sending request to delete a Activity");
		 Activity ac = activityService.deleteActivity(id);
		 logger.info("Activity deleted");
		 return new ResponseEntity<>(ac,HttpStatus.OK);
	 }
	
	@GetMapping("/getAllActivities/{chrg}")
	public ResponseEntity<List<Activity>> viewActivitiesOfCharges(@PathVariable float chrg){
		 logger.info("Sending request to view all Activity of same charge");
		List<Activity> allActivities=activityService.viewActivitiesOfCharges(chrg);
		 logger.info("Activities recieved");
		return new ResponseEntity<>(allActivities, HttpStatus.OK);
	}
	
	@GetMapping("/countActivitiesOfCharges/{charges}")
	public ResponseEntity<Integer> countActivity(@PathVariable float charges){
		logger.info("Sending request to count activities of same charge");
		int size = activityService.countActivitiesOfCharges(charges);
		logger.info("count of activities recieved");
		return new ResponseEntity<>(size, HttpStatus.OK);
	}
}