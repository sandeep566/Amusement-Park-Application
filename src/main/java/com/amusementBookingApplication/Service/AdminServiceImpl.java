package com.amusementBookingApplication.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amusementBookingApplication.Entity.Activity;
import com.amusementBookingApplication.Entity.Admin;
import com.amusementBookingApplication.Entity.Job;
import com.amusementBookingApplication.Entity.Login;
import com.amusementBookingApplication.Entity.TicketBooking;
import com.amusementBookingApplication.Exception.AdminExceptions;
import com.amusementBookingApplication.Exception.CustomerNotFoundException;
import com.amusementBookingApplication.Exception.InValidEmailException;
import com.amusementBookingApplication.Pojos.FieldName;
import com.amusementBookingApplication.Pojos.LoginRequest;
import com.amusementBookingApplication.Pojos.LoginUpdate;
import com.amusementBookingApplication.Repository.IActivityRepository;
import com.amusementBookingApplication.Repository.IAdminRepository;
import com.amusementBookingApplication.Repository.ITicketBookingRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private IAdminRepository adminRepo;
			
	@Autowired
	private ITicketBookingRepository ticketBookingRepo;
	
	@Autowired
	private TicketBookingServiceImpl ticketService;
	
	@Autowired
	private IActivityRepository iActivityRepo;
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	
	
	
	@Override
	public Admin saveAdmin(LoginRequest log) throws AdminExceptions,InValidEmailException {
		Optional<Admin> a1 = adminRepo.findById(log.getId());
		if(a1.isPresent()) {
			throw new AdminExceptions("Admin already exists");
		}
	    else {
			Admin c2 = new Admin();
			c2.setAdminId(log.getId());
			c2.setUsername(log.getUserName());
			c2.setFirstName(log.getFirstname());
			c2.setLastName(log.getLastName());
			c2.setEmail(log.getLoginEmail());
			c2.setPassword(log.getLogiPassword());
			c2.setMobileNumber(log.getMobileNo());
			Login l1 = new Login();
			l1.setJob(Job.Admin);
			l1.setLoggedIn(false);
			l1.setLoginEmail(log.getLoginEmail());
			l1.setLoginPassword(log.getLogiPassword());
			c2.setLogin(l1);
			String regex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(c2.getEmail());
			String phNo = "^[0-9]{10}$";
			Pattern ptrn = Pattern.compile(phNo);
			Matcher m2 = ptrn.matcher(c2.getMobileNumber()); 
			if(matcher.matches()==true && m2.matches()==true) {
				return adminRepo.save(c2);
			}else {
				throw new InValidEmailException("Invalid Email or Phone Number");
			}
	    }
	}

	public Admin update(LoginRequest log) throws AdminExceptions {
		Optional<Admin> a1 = adminRepo.findById(log.getId());
		if(a1.isPresent()) {
			Admin c2 = a1.get(); 
			c2.setAdminId(log.getId());
			c2.setUsername(log.getUserName());
			c2.setFirstName(log.getFirstname());
			c2.setLastName(log.getLastName());
			c2.setEmail(log.getLoginEmail());
			c2.setPassword(log.getLogiPassword());
			c2.setMobileNumber(log.getMobileNo());
			LoginUpdate l1 = new LoginUpdate();
			l1.setUpdateId(c2.getLogin().getId());
			l1.setEmail(c2.getEmail());
			l1.setPassword(c2.getPassword());
			String regex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(c2.getEmail());
			String phNo = "^[0-9]{10}$";
			Pattern ptrn = Pattern.compile(phNo);
			Matcher m2 = ptrn.matcher(c2.getMobileNumber()); 
			if(matcher.matches()==true && m2.matches()==true) {
				loginServiceImpl.updateLogIn(l1);
				return adminRepo.save(c2);
			}else {
				throw new InValidEmailException("Invalid Email or Phone Number");
			}
		}
		else{
			throw new AdminExceptions("Admin not found");
		}
	}

	@Override
	public Admin delete(Integer id) throws AdminExceptions {
		Admin existingAdmin = adminRepo.findById(id).orElseThrow(() -> new AdminExceptions("Invalid Id"));
		adminRepo.delete(existingAdmin);

		return existingAdmin;
	}
	
	@Override
	public List<Activity> getAllActivities(int id) {
		Iterable<TicketBooking> tickets =  ticketBookingRepo.findAll();
		List<Activity> l1 = new ArrayList<Activity>();
		for(TicketBooking t: tickets) {
			if(t.getCustomer().getCustomerId() == id) {
				l1.add(t.getActivity());
			}
		}return l1;
	}

	@Override
	public List<Activity> getDateWiseActivities() {
		FieldName f = new FieldName();
		Iterable<TicketBooking> l1 = ticketBookingRepo.findAll(Sort.by(Sort.Direction.ASC,f.getField()));
		List<Activity> l2 = new ArrayList<>();
		for(TicketBooking t: l1) {
			l2.add(t.getActivity());
		}return l2;
		
	}

	@Override
	public List<Activity> getAllForDays(int cId, Date fromDate, Date toDate) throws CustomerNotFoundException {
		Iterable<TicketBooking> lt = ticketService.getAllTicketsCustomer(cId);
		List<Activity> la = new ArrayList<>();
		LocalDate d1 = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate d2 = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		for(TicketBooking t: lt) {
			LocalDate d = t.getDateTime().toLocalDate();
			if(d.isAfter(d1) && d.isBefore(d2)) {
				la.add(t.getActivity());
			}
		}return la;
	}

	@Override
	public Iterable<Activity> getAll() {
		return iActivityRepo.findAll();
	}

	@Override
	public List<Activity> getCustomerWiseActivities() {
		FieldName f = new FieldName();
		Iterable<TicketBooking> l1 = ticketBookingRepo.findAll(Sort.by(Sort.Direction.ASC,f.getField1()));
		List<Activity> l2 = new ArrayList<>();
		for(TicketBooking t: l1) {
			l2.add(t.getActivity());
		}return l2;
		
	}

	
}

