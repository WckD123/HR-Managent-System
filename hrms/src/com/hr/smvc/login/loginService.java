package com.hr.smvc.login;

import java.util.ArrayList;

import com.hr.smvc.employee.employee;
//import com.hr.smvc.models.*;


//changed by Gopi

public interface loginService {
	
	//public boolean doesUserExist(User user) ;
	//int saveUser(User user) ;
	public ArrayList<employee> findAllEmployees() ;
	
	//public boolean doesEmailExist(employee emp);
	public employee findByEmail(String email);
	public employee findById(int user_id) ;

}
