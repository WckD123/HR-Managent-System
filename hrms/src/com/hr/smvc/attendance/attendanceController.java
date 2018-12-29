package com.hr.smvc.attendance;


import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hr.smvc.employee.empIdHelper;
import com.hr.smvc.employee.employee;
//import com.hr.smvc.helper.*;
//import com.hr.smvc.models.*;
//import com.hr.smvc.services.*;

@RestController
public class attendanceController{

	@Autowired
	attendanceService atdService;


	@RequestMapping(value= "/getAttendanceById" , method=RequestMethod.POST)
	public ResponseEntity<List<java.sql.Date>> getattendances(@RequestBody attendance ath) {
		System.out.println(ath.getEmp_id()+" "+ath.getPageno());
		List<java.sql.Date> atds = atdService.getAttendanceById(ath.getEmp_id(),ath.getPageno());
		
		return new ResponseEntity<List<java.sql.Date>>(atds, HttpStatus.OK);
	}


	@RequestMapping(value= "/admin/allatd" , method=RequestMethod.POST)
	public ResponseEntity<List<attendance>> getttendances(@RequestBody attendance ath) {
		List<attendance> atds = atdService.getAllattendances(ath.getPageno());
		return new ResponseEntity<List<attendance>>(atds, HttpStatus.OK);
	}


	@RequestMapping(value= "/setAttendance" , method=RequestMethod.POST)
	public ResponseEntity<Void> setAttendance(@RequestBody empIdHelper empIdH) {
		atdService.setAttendance(empIdH.getEmp_id());
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value= "/user/gjd" , method=RequestMethod.POST)
	public ResponseEntity<Date> getjd(@RequestBody employee emp, HttpServletRequest request) {
		Date ls = atdService.getjoiningdate(emp.getEmp_id());
		return new ResponseEntity<Date>(ls, HttpStatus.OK);
	}

	/*@RequestMapping(value = "/admin/updateatd" , method = RequestMethod.PUT)
	public ResponseEntity<attendance> updateattendances(@RequestBody attendance atd, HttpServletRequest request){
		HttpSession session = request.getSession();
		System.out.println("Inside Updateattendances");
		if (session.getAttribute("username")==null){
			if (atd==null){
				return new ResponseEntity<attendance>(HttpStatus.NOT_FOUND);
			}
			atdService.updateattendances(atd);
			return new ResponseEntity<attendance>(atd, HttpStatus.OK);
		} else {return null;}
	}*/
}
