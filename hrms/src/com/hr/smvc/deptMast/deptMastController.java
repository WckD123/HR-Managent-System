package com.hr.smvc.deptMast;


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
public class deptMastController{

	@Autowired
	deptMastService dmService;


	@RequestMapping(value= "/admin/alldm" , method=RequestMethod.GET)
	public ResponseEntity<List<deptMast>> getdept_masts() {
		List<deptMast> dms = dmService.getAlldept_masts();
		return new ResponseEntity<List<deptMast>>(dms, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/adddm" , method=RequestMethod.POST)
	public ResponseEntity<Void> adddept_masts(@RequestBody deptMast dm) {
		dmService.adddept_masts(dm);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updatedm" , method = RequestMethod.PUT)
	public ResponseEntity<deptMast> updatedept_masts(@RequestBody deptMast dm, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (dm==null){
				return new ResponseEntity<deptMast>(HttpStatus.NOT_FOUND);
			}
			dmService.updatedept_masts(dm);
			return new ResponseEntity<deptMast>(dm, HttpStatus.OK);
		} else {return null;}
	}
}
