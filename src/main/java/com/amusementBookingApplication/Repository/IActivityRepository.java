package com.amusementBookingApplication.Repository;




import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amusementBookingApplication.Entity.Activity;

@Repository
public interface IActivityRepository extends PagingAndSortingRepository<Activity, Integer> {
	
	

}
