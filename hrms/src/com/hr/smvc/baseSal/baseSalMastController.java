package com.hr.smvc.baseSal;


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
public class baseSalMastController{

	@Autowired
	baseSalMastService bsmService;


	@RequestMapping(value= "/admin/allbsm" , method=RequestMethod.GET)
	public ResponseEntity<List<baseSalMast>> getbase_sal_masts() {
		List<baseSalMast> bsms = bsmService.getAllbase_sal_masts();
		return new ResponseEntity<List<baseSalMast>>(bsms, HttpStatus.OK);
	}

	@RequestMapping(value= "/admin/addbsm" , method=RequestMethod.POST)
	public ResponseEntity<Void> addbase_sal_masts(@RequestBody baseSalMast bsm) {
		bsmService.addbase_sal_masts(bsm);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updatebsm" , method = RequestMethod.PUT)
	public ResponseEntity<baseSalMast> updatebase_sal_masts(@RequestBody baseSalMast bsm, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("usernbsme")==null){
			if (bsm==null){
				return new ResponseEntity<baseSalMast>(HttpStatus.NOT_FOUND);
			}
			bsmService.updatebase_sal_masts(bsm);
			return new ResponseEntity<baseSalMast>(bsm, HttpStatus.OK);
		} else {return null;}
	}
}
