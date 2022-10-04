package com.amusementBookingApplication.Service;

import com.amusementBookingApplication.Entity.Customer;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.InvalidId;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.LoginRequest;

public interface CustomerService {
	
	//public Customer addCustomer(Customer c) throws CustomerExistsException ;
	public Customer updateCustomer(LoginRequest customer) throws CustomerNotFoundException;
	public Iterable<Customer> viewAllCustomers();
	public Customer vaildCustomer(String Email, String Password) throws InvalidId ;
	Customer addCustomer(LoginRequest log);
	Customer deleteCustomer(int id) throws CustomerNotFoundException, TicketNotFoundException ;
	Customer getCustomer(int customerId) throws CustomerNotFoundException;
}
