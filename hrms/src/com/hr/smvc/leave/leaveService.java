package com.hr.smvc.leave;


import java.util.List;

public interface leaveService{
	
	public List<leave> getAllleaves(int pageno);
	public List<leave> getAppleaves();
	public List<leave> getaprleaves(leave b);
	public void addleaves(leave l);
	/*leave findById(long id);*/
	public void updateleaves(leave l);
	public int getRemainingLeaveDays(int emp_id);
	//public List<employee> findAllEmployees();
}