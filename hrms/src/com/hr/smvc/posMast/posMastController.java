package com.hr.smvc.posMast;


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
public class posMastController{

	@Autowired
	posMastService pmService;


	@RequestMapping(value= "/admin/allpm" , method=RequestMethod.GET)
	public ResponseEntity<List<posMast>> getpos_masts() {
		List<posMast> pms = pmService.getAllpos_masts();
		return new ResponseEntity<List<posMast>>(pms, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/addpm" , method=RequestMethod.POST)
	public ResponseEntity<Void> addpos_masts(@RequestBody posMast pm) {
		pmService.addpos_masts(pm);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updatepm" , method = RequestMethod.PUT)
	public ResponseEntity<posMast> updatepos_masts(@RequestBody posMast pm, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (pm==null){
				return new ResponseEntity<posMast>(HttpStatus.NOT_FOUND);
			}
			pmService.updatepos_masts(pm);
			return new ResponseEntity<posMast>(pm, HttpStatus.OK);
		} else {return null;}
	}
}
