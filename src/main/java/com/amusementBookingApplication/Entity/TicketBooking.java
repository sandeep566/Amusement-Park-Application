package com.amusementBookingApplication.Entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class TicketBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketBookingId;          //TicketBooking-ID
	
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")         //CustomerId(Foreign key)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;

	
	@ManyToOne(optional = false)
	@JoinColumn(name = "activity_id")          //Activity-Id(Foreign key)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Activity activity;
	
	private LocalDateTime dateTime;           //Date And Time
	//private float bill;
	
	
}