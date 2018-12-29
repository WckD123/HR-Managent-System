package com.hr.smvc.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.hr.smvc.models.*;
//import com.hr.smvc.services.*;
import com.hr.smvc.employee.employee;
//import com.hr.smvc.helper.*;
import org.springframework.http.MediaType;

@RestController
public class loginController {

	@Autowired
	loginService logService ;

	//changed By Gopi
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ResponseEntity<Void> getUserByEmail(@RequestBody loginHelper lHelper, HttpServletRequest request) {
		employee newEmp = logService.findByEmail(lHelper.getEmail_id()) ;
		HttpHeaders headers = new HttpHeaders();
		System.out.println(lHelper.getEmp_password());
		System.out.println(lHelper.getEmail_id());
		System.out.println(newEmp);
		System.out.println(newEmp);
		if(newEmp.getEmail_id() == null) {
			return new ResponseEntity<Void>(headers, HttpStatus.NOT_FOUND);
		} else if (!(newEmp.getPassword().equals(lHelper.getEmp_password()))){
			return new ResponseEntity<Void>(headers, HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<Void>(headers, HttpStatus.OK);
		}
	}

}

