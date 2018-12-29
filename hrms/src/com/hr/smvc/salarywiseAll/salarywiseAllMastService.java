package com.hr.smvc.salarywiseAll;


import java.util.List;

public interface salarywiseAllMastService{
	
	public List<salarywiseAllMast> getAllsalarywise_all_masts();
//	public void addEmployees(employee emp);
	public void addsalarywise_all_masts(salarywiseAllMast sam);
	salarywiseAllMast findById(long id);
	public void updatesalarywise_all_masts(salarywiseAllMast sam);
	//public List<employee> findAllEmployees();
}
