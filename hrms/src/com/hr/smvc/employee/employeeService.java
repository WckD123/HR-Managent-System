package com.hr.smvc.employee;


import java.util.List;

public interface employeeService{
	
	public List<employee> getAllEmployees(int pageno);
//	public void addEmployees(employee emp);
	public Integer addEmployees(employee emp);
	employee findById(int id);
	public void updateEmployees(employee emp);
	public void updateEmployeesemail(employee emp);
	public void updateEmployeesmob(employee emp);
	public void updateEmployeesadd(employee emp);
	public void updateEmployeesms(employee emp);
	//public List<employee> findAllEmployees();
	public empIdHelper getIdByEmail(String str);
	
}
