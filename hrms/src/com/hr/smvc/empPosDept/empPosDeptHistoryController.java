package com.hr.smvc.empPosDept;


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
//import com.hr.smvc.services.*;

@RestController
public class empPosDeptHistoryController{

	@Autowired
	empPosDeptHistoryService epdhService;


	@RequestMapping(value= "/admin/allepdh" , method=RequestMethod.POST)
	public ResponseEntity<List<empPosDeptHistory>> getAllEmp_pos_dept_historys(@RequestBody empIdHelper emp) {
		List<empPosDeptHistory> epdhs = epdhService.getAllemp_pos_dept_historys(emp.getPageno());
		return new ResponseEntity<List<empPosDeptHistory>>(epdhs, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/user/epdh" , method=RequestMethod.POST)
	public ResponseEntity<List<empPosDeptHistory>> getemp_pos_dept_history(@RequestBody employee emp) {
		List<empPosDeptHistory> epdhs = epdhService.getEmp_pos_dept_historys(emp.getEmp_id());
		return new ResponseEntity<List<empPosDeptHistory>>(epdhs, HttpStatus.OK);
	}
	
	

	@RequestMapping(value= "/admin/addepdh" , method=RequestMethod.POST)
	public ResponseEntity<Void> addemp_pos_dept_historys(@RequestBody empPosDeptHistory epdh) {
		epdhService.addemp_pos_dept_historys(epdh);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/admin/updateepdh" , method = RequestMethod.PUT)
	public ResponseEntity<empPosDeptHistory> updateemp_pos_dept_historys(@RequestBody empPosDeptHistory epdh, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("usernepdhe")==null){
			if (epdh==null){
				return new ResponseEntity<empPosDeptHistory>(HttpStatus.NOT_FOUND);
			}
			epdhService.updateemp_pos_dept_historys(epdh);
			return new ResponseEntity<empPosDeptHistory>(epdh, HttpStatus.OK);
		} else {return null;}
	}
}
