package com.amusementBookingApplication.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amusementBookingApplication.Entity.Activity;
import com.amusementBookingApplication.Entity.Customer;
import com.amusementBookingApplication.Entity.TicketBooking;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.NoSuchActivityExistsException;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.TicketsRequest;
import com.amusementBookingApplication.Pojos.TripBooking;
import com.amusementBookingApplication.Repository.IActivityRepository;
import com.amusementBookingApplication.Repository.ICustomerRepository;
import com.amusementBookingApplication.Repository.ITicketBookingRepository;

@Service
public class TicketBookingServiceImpl implements TicketBookingService{
	
	@Autowired 
	private ITicketBookingRepository iTicketBookingRepository; //TicketBooking Repository
	@Autowired
	private IActivityRepository iActivityRepository;        //Activity Repository
	@Autowired
	private ICustomerRepository iCustomerRepository;       //Customer Repository
	
	//Method for Adding TicketBooking

	@Override
	public TicketBooking addTicketBooking(TicketsRequest ticket) throws CustomerNotFoundException,NoSuchActivityExistsException {
		Optional<Activity> ac =  iActivityRepository.findById(ticket.activity_id);
		Optional<Customer> customer = iCustomerRepository.findById(ticket.customer_id);
		if(customer.isPresent()) {
			if(ac.isPresent()) {
				Customer c1 = customer.get();
				Activity a1 = ac.get();
				TicketBooking tb = new TicketBooking();
				//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
				LocalDateTime ldt = LocalDateTime.now();
				//String ldtString = formatter.format(ldt);
				tb.setTicketBookingId(ticket.ticketBookingId);
				tb.setDateTime(ldt);
				tb.setActivity(a1);
				tb.setCustomer(c1);
				return iTicketBookingRepository.save(tb);
			}else {
				throw new NoSuchActivityExistsException("Activity Not Found");
			}
		}else {
			throw new CustomerNotFoundException("Customer Not Found");
		}
	}
	
	
	//Method for Updating TicketBooking

	@Override
	public TicketBooking updateTicketBooking(TicketsRequest ticket) throws TicketNotFoundException {
		Optional<TicketBooking> tb1 = iTicketBookingRepository.findById(ticket.ticketBookingId);
		Optional<Activity> ac =  iActivityRepository.findById(ticket.activity_id);
		Optional<Customer> customer = iCustomerRepository.findById(ticket.customer_id);
		if(tb1.isPresent()) {
			Customer c1 = customer.get();
			Activity a1 = ac.get();
			TicketBooking tb2 = tb1.get();
			tb2.setActivity(a1);
			tb2.setCustomer(c1);
				
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");
			LocalDateTime ldt = LocalDateTime.now();
			//String ldtString = formatter.format(ldt);
			tb2.setDateTime(ldt);
			return iTicketBookingRepository.save(tb2);
		}else {
			throw new TicketNotFoundException("Ticket Not Found");
		}
	}

	
	//Delete TicketBooking Ticket-id

	@Override
	public TicketBooking deleteTicketBooking(int id) throws TicketNotFoundException {
		Optional<TicketBooking> tb = iTicketBookingRepository.findById(id);
		TicketBooking t1 = tb.get();
		if(tb.isPresent()) {
			iTicketBookingRepository.deleteById(id);
			return t1;
		}else {
			throw new TicketNotFoundException("Ticket Not Found");
		}
	}
	
	//Mthod for getting all Tickets of a customer

	@Override
	public List<TicketBooking> getAllTicketsCustomer(int id1) throws CustomerNotFoundException {
			Iterable<TicketBooking> l1 = iTicketBookingRepository.findAll();
			List<TicketBooking> l2 = new ArrayList<>();
			for(TicketBooking t: l1) {
				if(t.getCustomer().getCustomerId() == id1) {
					l2.add(t);
				}
			}return l2;
	}
	
	
	//Mthod for Calculating Bill
	

	@Override
	public TripBooking calculateBill(int id) throws CustomerNotFoundException {
			Iterable<TicketBooking> l1 = iTicketBookingRepository.findAll();
			Optional<Customer> c = iCustomerRepository.findById(id);
			if(c.isPresent()) {
				Customer c1 = c.get();
				List<Activity> l2 = new ArrayList<>();
				TripBooking tp = new TripBooking();
				float bill = 0;
				for(TicketBooking t: l1) {
					if(t.getCustomer().getCustomerId() == id) {
						l2.add(t.getActivity());
						bill += t.getActivity().getCharges();
					}
					
				}
				tp.setBill(bill);
				tp.setCustomerId(id);
				tp.setName(c1.getUsername());
				tp.setActivities(l2);
				return tp;
			}
			else {
				throw new CustomerNotFoundException("Customer Not Found");
			}
			
	}
}

