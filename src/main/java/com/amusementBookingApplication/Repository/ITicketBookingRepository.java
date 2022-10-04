package com.amusementBookingApplication.Repository;




import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amusementBookingApplication.Entity.TicketBooking;


@Repository
public interface ITicketBookingRepository extends PagingAndSortingRepository<TicketBooking , Integer>{
	
	
}
