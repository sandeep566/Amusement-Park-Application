package com.amusementBookingApplication.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.amusementBookingApplication.Entity.Activity;
import com.amusementBookingApplication.Exception.NoSuchActivityExistsException;
import com.amusementBookingApplication.Repository.IActivityRepository;
import com.amusementBookingApplication.Service.ActivityServiceImpl;

@SpringBootTest
public class ActivityTest {

	@Mock
	IActivityRepository iac;
	
	@InjectMocks
	ActivityServiceImpl asi;
	
	@Test
	void addActivityTest() {
		Activity ac = new Activity(1,"equinox",100);
		
		when(iac.save(ac)).thenReturn(ac);
		assertEquals(ac,asi.addActivity(ac));
	}
	
	@Test
	void updateActivityTest() throws NoSuchActivityExistsException {
		Activity a =  new Activity(1,"Roller Coaster",200);
		Activity a1=new Activity(1,"Giant wheel",300);
		when(iac.findById(a.getActivityId())).thenReturn(Optional.of(a));
		when(iac.save(a)).thenReturn(a);
		assertEquals(a, asi.updateActivity(a1));
}
	
}
