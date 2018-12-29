package com.hr.smvc.allowance;


import java.util.List;

public interface allowanceMastService{
	
	public List<allowanceMast> getAllAllowances();

	public void addAllowances(allowanceMast am);
	allowanceMast findById(long id);
	public void updateAllowances(allowanceMast am);
	//public List<employee> findAllEmployees();
}