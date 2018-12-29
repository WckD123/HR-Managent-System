package com.hr.smvc.desAll;


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
public class desAllMastController{

	@Autowired
	desAllMastService damService;


	@RequestMapping(value= "/admin/alldam" , method=RequestMethod.GET)
	public ResponseEntity<List<desAllMast>> getAllowances() {
		List<desAllMast> dams = damService.getAlldes_all_masts();
		return new ResponseEntity<List<desAllMast>>(dams, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/adddam" , method=RequestMethod.POST)
	public ResponseEntity<Void> addAllowances(@RequestBody desAllMast dam) {
		damService.adddes_all_masts(dam);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updatedam" , method = RequestMethod.PUT)
	public ResponseEntity<desAllMast> updateAllowances(@RequestBody desAllMast dam, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("userndame")==null){
			if (dam==null){
				return new ResponseEntity<desAllMast>(HttpStatus.NOT_FOUND);
			}
			damService.updatedes_all_masts(dam);
			return new ResponseEntity<desAllMast>(dam, HttpStatus.OK);
		} else {return null;}
	}
}
