package com.hr.smvc.desAll;


import java.util.List;

public interface desAllMastService{
	
	public List<desAllMast> getAlldes_all_masts();

	public void adddes_all_masts(desAllMast dam);
	desAllMast findById(long id);
	public void updatedes_all_masts(desAllMast dam);
	//public List<employee> findAllEmployees();
}