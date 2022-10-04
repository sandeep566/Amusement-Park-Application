package com.amusementBookingApplication.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amusementBookingApplication.Entity.Customer;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

}
