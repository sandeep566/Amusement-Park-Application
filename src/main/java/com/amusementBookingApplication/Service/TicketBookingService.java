package com.amusementBookingApplication.Service;

import java.util.List;


import com.amusementBookingApplication.Entity.TicketBooking;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.TicketsRequest;
import com.amusementBookingApplication.Pojos.TripBooking;

public interface TicketBookingService {
	
	public List<TicketBooking> getAllTicketsCustomer(int id) throws CustomerNotFoundException;
	
	public TicketBooking addTicketBooking(TicketsRequest ticket) throws CustomerNotFoundException;
	
	public TicketBooking updateTicketBooking(TicketsRequest ticket) throws TicketNotFoundException;
	
	public TicketBooking deleteTicketBooking(int id) throws TicketNotFoundException;
	
	public TripBooking calculateBill(int id) throws CustomerNotFoundException ;
}
