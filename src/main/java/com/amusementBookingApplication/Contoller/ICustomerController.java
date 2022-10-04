package com.amusementBookingApplication.Contoller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amusementBookingApplication.Entity.Customer;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.LoginRequest;
import com.amusementBookingApplication.Service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class ICustomerController {
	
	@Autowired
	private CustomerServiceImpl iCustomerService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/insertCustomer")
	public ResponseEntity<Customer> insertCustomer(@RequestBody LoginRequest c) {
		logger.info("Sending request to Add a Customer");
		Customer c1 =  iCustomerService.addCustomer(c);
		logger.info("Customer Added");
		return new ResponseEntity<>(c1,HttpStatus.OK);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> update(@RequestBody  LoginRequest customer) throws CustomerNotFoundException  {
		
		logger.info("Sending request to Update a Customer");
		Customer updatedCustomer = iCustomerService.updateCustomer(customer);
		logger.info("Updated the Customer in the Database");
		return new ResponseEntity<>(updatedCustomer,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<Customer> delete(@PathVariable int id) throws CustomerNotFoundException, TicketNotFoundException{
		logger.info("Sending request to delete a Customer");
		Customer c1 = iCustomerService.deleteCustomer(id);
		logger.info("customer deleted");
		return new ResponseEntity<>(c1,HttpStatus.OK);
	}
	
	@GetMapping("/view/all")
	public ResponseEntity<Iterable<Customer>> viewCustomers(){
		logger.info("Sending request to view all Customer");
		Iterable<Customer> i1 = iCustomerService.viewAllCustomers();
		logger.info("All customers received");
		return new ResponseEntity<>(i1,HttpStatus.OK);
	}
	
	@GetMapping("/validation")
	public ResponseEntity<Customer> validCustomer(@RequestParam String email,@RequestParam String password){
		logger.info("Sending request to validate Customer");
		Customer c = iCustomerService.vaildCustomer(email,password);
		logger.info("Customer Validated");
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
	
	@GetMapping("/viewCustomer/{id}")
	ResponseEntity<Customer> get(@PathVariable int id ) throws CustomerNotFoundException  {
    logger.info("Sending request to Delete a Customer");
    Customer AvailableCustomer = iCustomerService.getCustomer(id);
    logger.info("Removed a customer from the Database");
    return new ResponseEntity<>(AvailableCustomer,HttpStatus.OK);
	
	}
	
	
	

}
