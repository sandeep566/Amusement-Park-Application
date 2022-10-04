package com.amusementBookingApplication.Repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amusementBookingApplication.Entity.Login;

@Repository
public interface ILoginRepository extends PagingAndSortingRepository<Login, Integer> {
	
	Optional<Login> findByLoginEmail(String loginEmail);

}
