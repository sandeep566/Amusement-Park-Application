package com.amusementBookingApplication.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amusementBookingApplication.Entity.Customer;
import com.amusementBookingApplication.Entity.Job;
import com.amusementBookingApplication.Entity.Login;
import com.amusementBookingApplication.Exception.CustomerExistsException;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.InValidEmailException;
import com.amusementBookingApplication.Exception.InvalidId;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.LoginRequest;
import com.amusementBookingApplication.Pojos.LoginUpdate;
import com.amusementBookingApplication.Repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ICustomerRepository icustomerrepo;
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	

	
	@Override
	public Customer addCustomer(LoginRequest log) {
		Optional<Customer> c1 = icustomerrepo.findById(log.getId());
		if(c1.isPresent()) {
			throw new CustomerExistsException("Customer already exists");
		}
		Customer c2 = new Customer();
		c2.setCustomerId(log.getId());
		c2.setUsername(log.getUserName());
		c2.setFirstName(log.getFirstname());
		c2.setLastName(log.getLastName());
		c2.setEmail(log.getLoginEmail());
		c2.setPassword(log.getLogiPassword());
		c2.setMobileNumber(log.getMobileNo());
		Login l1 = new Login();
		l1.setJob(Job.Customer);
		l1.setLoggedIn(false);
		l1.setLoginEmail(log.getLoginEmail());
		l1.setLoginPassword(log.getLogiPassword());
		c2.setLogin(l1);
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(c2.getEmail());
		String phNo = "^[0-9]{10}$";
		Pattern ptrn = Pattern.compile(phNo);
		Matcher m2 = ptrn.matcher(c2.getMobileNumber()); 
		if(matcher.matches()==true && m2.matches()==true) {
			return icustomerrepo.save(c2);
		}else {
			throw new InValidEmailException("Invalid Email or Phone Number");
		}
	}
	
	@Override
	public Customer updateCustomer(LoginRequest customer)  throws CustomerNotFoundException{
		Optional<Customer> act = icustomerrepo.findById(customer.getId());
			if(act.isPresent()) {
				Customer c = act.get();
				c.setUsername(customer.getUserName());
				c.setFirstName(customer.getFirstname());
				c.setLastName(customer.getLastName());
				c.setEmail(customer.getLoginEmail());
				c.setMobileNumber(customer.getMobileNo());
				c.setPassword(customer.getLogiPassword());
				LoginUpdate l1 = new LoginUpdate();
				l1.setUpdateId(c.getLogin().getId());
				l1.setEmail(c.getEmail());
				l1.setPassword(c.getPassword());
				String regex = "^(.+)@(.+)$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(c.getEmail());
				String phNo = "^[0-9]{10}$";
				Pattern ptrn = Pattern.compile(phNo);
				Matcher m2 = ptrn.matcher(c.getMobileNumber()); 
				if(matcher.matches()==true && m2.matches()==true) {
					loginServiceImpl.updateLogIn(l1);
					return icustomerrepo.save(c);
				}else {
					throw new InValidEmailException("Invalid Email or Phone Number");
				}
			}
			else {
				throw new CustomerNotFoundException("Customer Not Found");
			}
		}	

	@Override
	public Customer deleteCustomer(int id) throws CustomerNotFoundException, TicketNotFoundException {
		Optional<Customer> act = icustomerrepo.findById(id);
		if(act.isPresent()) {
			Customer c = act.get();
			icustomerrepo.deleteById(id);
			return c;
		}else {
			throw new CustomerNotFoundException("Customer Not Found");
		}
	}
	
	public Iterable<Customer> viewAllCustomers(){
		return icustomerrepo.findAll();
	}
	

	@Override
	public Customer vaildCustomer(String Email, String Password) throws InvalidId {		
		List<Customer> c1  = (List<Customer>) icustomerrepo.findAll();
		for(int i= 0; i < c1.size(); i++) {
			if(c1.get(i).getEmail().equals(Email) && c1.get(i).getPassword().equals(Password))
			     return c1.get(i);
			}
		 throw new InvalidId("Invalid Email and password");
	}

	@Override
	public Customer getCustomer(int customerId) throws CustomerNotFoundException {
		Optional<Customer> c3 = icustomerrepo.findById(customerId);
		if(c3.isPresent()) {
			Customer viewCustomer=c3.get();
			icustomerrepo.findById(customerId);
			return viewCustomer;
		
		
		}
		else {
			throw new CustomerNotFoundException("Customer not Found with the given ID: "+customerId);
		}
	
	}
}



