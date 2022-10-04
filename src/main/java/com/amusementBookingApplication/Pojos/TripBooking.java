package com.amusementBookingApplication.Pojos;

import java.util.List;

import com.amusementBookingApplication.Entity.Activity;

import lombok.Data;



@Data
public class TripBooking {
	
	
	public int customerId;
	public String name;
	public float bill;
	public List<Activity> activities;
	
}
