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

import com.amusementBookingApplication.Entity.TicketBooking;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.NoSuchActivityExistsException;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.TicketsRequest;
import com.amusementBookingApplication.Pojos.TripBooking;
import com.amusementBookingApplication.Service.TicketBookingServiceImpl;


//REST API 
@RestController
@RequestMapping("api/ticket")
public class ITicketBookingController {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private TicketBookingServiceImpl iTicketBookingService;
	
	//Sending 'POST' request for Adding Ticket
	
	@PostMapping("/addTicketBooking")
	public ResponseEntity<TicketBooking> addTicket(@RequestBody TicketsRequest ticket) throws NoSuchActivityExistsException, CustomerNotFoundException {
		logger.info("Sending request to Add ticket");
		TicketBooking tb =  iTicketBookingService.addTicketBooking(ticket);
		logger.info("Ticket Added to the database");
		return new ResponseEntity<>(tb,HttpStatus.OK);
	}
	
	//Sending 'PUT' request for Updating Ticket
	
	@PutMapping("/updateTicketBooking")
	public ResponseEntity<TicketBooking> updateTicket(@RequestBody TicketsRequest ticket) throws TicketNotFoundException {
		logger.info("Updating ticket details");
		TicketBooking tb = iTicketBookingService.updateTicketBooking(ticket);
		logger.info("Ticket Updated");
		return new ResponseEntity<>(tb,HttpStatus.OK);
	}
	
	//Sending 'DELETE' request for Deleting Ticket
	
	@DeleteMapping("/deleteTicket/{id}")
	public ResponseEntity<TicketBooking> deleteTicket(@PathVariable int id ) throws TicketNotFoundException{
		logger.info("Deleting ticket details");
		TicketBooking tb = iTicketBookingService.deleteTicketBooking(id);
		logger.info("Deleting Ticket");
		return new ResponseEntity<>(tb,HttpStatus.OK);
	}
	
	//Sending 'GET' request for retrieving all the Tickets based on Customer-ID
	
	@GetMapping("/viewAllTicketsCustomer/{id}")
	public ResponseEntity<List<TicketBooking>> getAllTickets(@PathVariable int id) throws CustomerNotFoundException{
		logger.info("Getting List of tickets of given customerId");
		List<TicketBooking> ltb = iTicketBookingService.getAllTicketsCustomer(id);
		logger.info("Tickets List recieved");
		return new ResponseEntity<>(ltb,HttpStatus.OK);
	}
	
	//Sending 'GET' request for Calculating the Bill of the Customer for his/her tickets
	
	@GetMapping("/calculateBill/{id}")
	public ResponseEntity<TripBooking> getBill(@PathVariable int id) throws CustomerNotFoundException{
		logger.info("Generating Bill");
		TripBooking tb = iTicketBookingService.calculateBill(id);
		logger.info("Bill Generated");
		return new ResponseEntity<>(tb,HttpStatus.OK);
		
	}
}
