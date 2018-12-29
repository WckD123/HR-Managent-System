package com.hr.smvc.leave;


import java.util.List;

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

import com.hr.smvc.employee.*;
//import com.hr.smvc.models.*;
//import com.hr.smvc.services.*;

@RestController
public class leaveController{

	@Autowired
	leaveService lService;


	@RequestMapping(value= "/admin/alll" , method=RequestMethod.POST)
	public ResponseEntity<List<leave>> getleaves(@RequestBody empIdHelper emp) {
		List<leave> ls = lService.getAllleaves(emp.getPageno());
		return new ResponseEntity<List<leave>>(ls, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/apple" , method=RequestMethod.GET)
	public ResponseEntity<List<leave>> getappleaves() {
		List<leave> ls = lService.getAppleaves();
		return new ResponseEntity<List<leave>>(ls, HttpStatus.OK);
	}
	@RequestMapping(value= "/user/caplll" , method=RequestMethod.POST)
	public ResponseEntity<List<leave>> getapleaves(@RequestBody leave b, HttpServletRequest request) {
		List<leave> ls = lService.getaprleaves(b);
		return new ResponseEntity<List<leave>>(ls, HttpStatus.OK);
	}
	@RequestMapping(value= "/user/addl" , method=RequestMethod.POST)
	public ResponseEntity<Void> applyleaves(@RequestBody leave l) {
		lService.addleaves(l);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value= "/admin/addl" , method=RequestMethod.POST)
	public ResponseEntity<Void> addleaves(@RequestBody leave l) {

		lService.addleaves(l);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/admin/updatel" , method = RequestMethod.POST)
	public ResponseEntity<leave> updateleaves(@RequestBody leave l, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("usernle")==null){
			if (l==null){
				return new ResponseEntity<leave>(HttpStatus.NOT_FOUND);
			}
			lService.updateleaves(l);
			return new ResponseEntity<leave>(l, HttpStatus.OK);
		} else {return null;}
	}

	@RequestMapping(value = "/user/getRemainingLeaveDays" , method = RequestMethod.POST)
	public ResponseEntity<Integer> remainingLeaveDays(@RequestBody employee emp, HttpServletRequest request){
		@SuppressWarnings("unused")
		HttpSession session = request.getSession();
		int lleft;
		lleft = lService.getRemainingLeaveDays(emp.getEmp_id());
		return new ResponseEntity<Integer>(lleft, HttpStatus.OK);
	}

}

