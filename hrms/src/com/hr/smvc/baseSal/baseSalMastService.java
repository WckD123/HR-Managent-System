package com.hr.smvc.baseSal;


import java.util.List;

public interface baseSalMastService{
	
	public List<baseSalMast> getAllbase_sal_masts();

	public void addbase_sal_masts(baseSalMast bsm);
	baseSalMast findById(long id);
	public void updatebase_sal_masts(baseSalMast bsm);
	//public List<employee> findAllEmployees();
}