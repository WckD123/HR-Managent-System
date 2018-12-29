package com.hr.smvc.deptMast;


import java.util.List;

public interface deptMastService{
	
	public List<deptMast> getAlldept_masts();
//	public void addEmployees(employee emp);
	public void adddept_masts(deptMast dm);
	deptMast findById(long id);
	public void updatedept_masts(deptMast dm);
	//public List<employee> findAllEmployees();
}
