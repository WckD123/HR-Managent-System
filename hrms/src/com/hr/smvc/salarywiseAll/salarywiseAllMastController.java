package com.hr.smvc.salarywiseAll;


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
public class salarywiseAllMastController{

	@Autowired
    salarywiseAllMastService samService;


	@RequestMapping(value= "/admin/allsam" , method=RequestMethod.GET)
	public ResponseEntity<List<salarywiseAllMast>> getsalarywise_all_masts() {
		List<salarywiseAllMast> sams = samService.getAllsalarywise_all_masts();
		return new ResponseEntity<List<salarywiseAllMast>>(sams, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/addsam" , method=RequestMethod.POST)
	public ResponseEntity<Void> addsalarywise_all_masts(@RequestBody salarywiseAllMast sam) {
		samService.addsalarywise_all_masts(sam);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

	@RequestMapping(value = "/admin/updatesam" , method = RequestMethod.PUT)
	public ResponseEntity<salarywiseAllMast> updatesalarywise_all_masts(@RequestBody salarywiseAllMast sam, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (sam==null){
				return new ResponseEntity<salarywiseAllMast>(HttpStatus.NOT_FOUND);
			}
			samService.updatesalarywise_all_masts(sam);
			return new ResponseEntity<salarywiseAllMast>(sam, HttpStatus.OK);
		} else {return null;}
	}
}
