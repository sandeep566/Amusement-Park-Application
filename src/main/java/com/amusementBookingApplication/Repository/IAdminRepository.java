package com.amusementBookingApplication.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amusementBookingApplication.Entity.Admin;

@Repository
public interface IAdminRepository extends PagingAndSortingRepository<Admin, Integer> {

	

}
