package com.hr.smvc.posMast;


import java.util.List;

public interface posMastService{
	
	public List<posMast> getAllpos_masts();
//	public void addEmployees(employee emp);
	public void addpos_masts(posMast pm);
	posMast findById(long id);
	public void updatepos_masts(posMast pm);
	//public List<employee> findAllEmployees();
}
