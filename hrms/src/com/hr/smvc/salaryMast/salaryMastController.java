package com.hr.smvc.salaryMast;


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

//import com.hr.smvc.services.*;

@RestController
public class salaryMastController{

	@Autowired
	salaryMastService smService;


	@RequestMapping(value= "/admin/allsm" , method=RequestMethod.GET)
	public ResponseEntity<List<salaryMast>> getsalary_masts() {
		List<salaryMast> sms = smService.getAllsalary_masts();
		return new ResponseEntity<List<salaryMast>>(sms, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/addsm" , method=RequestMethod.POST)
	public ResponseEntity<Void> addsalary_masts(@RequestBody salaryMast sm) {
		smService.addsalary_masts(sm);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updatesm" , method = RequestMethod.PUT)
	public ResponseEntity<salaryMast> updatesalary_masts(@RequestBody salaryMast sm, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (sm==null){
				return new ResponseEntity<salaryMast>(HttpStatus.NOT_FOUND);
			}
			smService.updatesalary_masts(sm);
			return new ResponseEntity<salaryMast>(sm, HttpStatus.OK);
		} else {return null;}
	}
}
