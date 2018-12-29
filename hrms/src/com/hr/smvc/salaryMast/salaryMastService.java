package com.hr.smvc.salaryMast;


import java.util.List;

public interface salaryMastService{
	
	public List<salaryMast> getAllsalary_masts();
//	public void addEmployees(employee emp);
	public void addsalary_masts(salaryMast sm);
	salaryMast findById(long id);
	public void updatesalary_masts(salaryMast sm);
	//public List<employee> findAllEmployees();
}
