package com.amusementBookingApplication.Service;

import java.util.Date;
import java.util.List;


import com.amusementBookingApplication.Entity.Activity;
import com.amusementBookingApplication.Entity.Admin;
import com.amusementBookingApplication.Exception.AdminExceptions;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.TicketNotFoundException;
import com.amusementBookingApplication.Pojos.LoginRequest;


public interface AdminService {
	
	
	//public Admin update(LoginRequest log) throws AdminExceptions;
	
	public Admin delete(Integer id) throws AdminExceptions;
	
	//public List<Activity> getAllActivities(Integer id) throws CustomerNotFoundException;

	List<Activity> getAllActivities(int id);

	Admin saveAdmin(LoginRequest log) throws AdminExceptions;

	//public List<Activity> getDateWiseActivities();
	
	List<Activity> getAllForDays(int cId, Date fromDate, Date toDate) throws CustomerNotFoundException, TicketNotFoundException ;

	Iterable<Activity> getAll();

	List<Activity> getDateWiseActivities();

	List<Activity> getCustomerWiseActivities();

}
