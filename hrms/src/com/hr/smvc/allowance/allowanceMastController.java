package com.hr.smvc.allowance;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import com.hr.smvc.models.*;
//import com.hr.smvc.services.*;

@RestController
@SuppressWarnings("all")
public class allowanceMastController{

	@Autowired
	allowanceMastService AmService;


	@RequestMapping(value= "/admin/allAm" , method=RequestMethod.GET)
	public ResponseEntity<List<allowanceMast>> getAllowances() {
		List<allowanceMast> Ams = AmService.getAllAllowances();
		for (int i=0; i<Ams.size();i++) {
			allowanceMast Am = Ams.get(i);
		}
		return new ResponseEntity<List<allowanceMast>>(Ams, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/addAm" , method=RequestMethod.POST)
	public ResponseEntity<Void> addAllowances(@RequestBody allowanceMast Am) {


		AmService.addAllowances(Am);

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updateAm" , method = RequestMethod.PUT)
	public ResponseEntity<allowanceMast> updateAllowances(@RequestBody allowanceMast Am, HttpServletRequest request){
		HttpSession session = request.getSession();
		System.out.println("Inside UpdateAllowances");
		if (session.getAttribute("username")==null){

			if (Am==null){
				return new ResponseEntity<allowanceMast>(HttpStatus.NOT_FOUND);
			}
			AmService.updateAllowances(Am);

			return new ResponseEntity<allowanceMast>(Am, HttpStatus.OK);
		} else {return null;}
	}
}
