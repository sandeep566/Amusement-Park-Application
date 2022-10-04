package com.amusementBookingApplication.Pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketsRequest {
	public int ticketBookingId;
	public int activity_id;
	public int customer_id;
	
	
}
