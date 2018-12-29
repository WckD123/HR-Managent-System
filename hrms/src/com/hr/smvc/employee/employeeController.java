package com.hr.smvc.employee;


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

//import com.hr.smvc.helper.*;
//import com.hr.smvc.services.*;


@RestController
public class employeeController{

	@Autowired
	employeeService EmpService;


	@RequestMapping(value= "/admin/allEmp" , method=RequestMethod.POST)
	public ResponseEntity<List<employee>> getEmployees(@RequestBody empIdHelper emp) {
		List<employee> emps = EmpService.getAllEmployees(emp.getPageno());
		return new ResponseEntity<List<employee>>(emps, HttpStatus.OK);
	}


	@RequestMapping(value= "/admin/addEmp" , method=RequestMethod.POST)
	public ResponseEntity<Integer> addEmployees(@RequestBody employee emp) {
		int i= EmpService.addEmployees(emp);
		//empIdHelper empH = EmpService.getIdByEmail(emp1.getEmail_id());
		return new ResponseEntity<Integer>(i, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/admin/updateEmp" , method = RequestMethod.PUT)
	public ResponseEntity<employee> updateEmployees(@RequestBody employee emp, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (emp==null){
				return new ResponseEntity<employee>(HttpStatus.NOT_FOUND);
			}
			EmpService.updateEmployees(emp);
			return new ResponseEntity<employee>(emp, HttpStatus.OK);
		} else {
			return null;
		}
	}
	@RequestMapping(value = "/user/updateEmpemail" , method = RequestMethod.PUT)
	public ResponseEntity<employee> updateEmployeesemail(@RequestBody employee emp, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (emp==null){
				return new ResponseEntity<employee>(HttpStatus.NOT_FOUND);
			}
			EmpService.updateEmployeesemail(emp);
			return new ResponseEntity<employee>(emp, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/user/updateEmpms" , method = RequestMethod.PUT)
	public ResponseEntity<employee> updateEmployeesms(@RequestBody employee emp, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (emp==null){
				return new ResponseEntity<employee>(HttpStatus.NOT_FOUND);
			}
			EmpService.updateEmployeesms(emp);
			return new ResponseEntity<employee>(emp, HttpStatus.OK);
		} else {
			return null;
		}
	}
	@RequestMapping(value = "/user/updateEmpmob" , method = RequestMethod.PUT)
	public ResponseEntity<employee> updateEmployeesmob(@RequestBody employee emp, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (emp==null){
				return new ResponseEntity<employee>(HttpStatus.NOT_FOUND);
			}
			EmpService.updateEmployeesmob(emp);
			return new ResponseEntity<employee>(emp, HttpStatus.OK);
		} else {
			return null;
		}
	}
	@RequestMapping(value = "/user/updateEmpadd" , method = RequestMethod.PUT)
	public ResponseEntity<employee> updateEmployeesadd(@RequestBody employee emp, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (session.getAttribute("username")==null){
			if (emp==null){
				return new ResponseEntity<employee>(HttpStatus.NOT_FOUND);
			}
			EmpService.updateEmployeesadd(emp);
			return new ResponseEntity<employee>(emp, HttpStatus.OK);
		} else {
			return null;
		}
	}

	@RequestMapping(value= "/getIdByEmail" , method=RequestMethod.POST)
	public ResponseEntity<empIdHelper> findById(@RequestBody emailIdHelper emailIdH, HttpServletRequest request) {
		empIdHelper emph = EmpService.getIdByEmail(emailIdH.getEmail_id());
		return new ResponseEntity<empIdHelper>(emph, HttpStatus.OK);
	}


	// For Checking the function
	@RequestMapping(value= "/findById" , method=RequestMethod.POST)
	public ResponseEntity<employee> findById(@RequestBody employee emp, HttpServletRequest request) {
		emp = EmpService.findById(emp.getEmp_id());
		return new ResponseEntity<employee>(emp, HttpStatus.OK);
	}
	

}