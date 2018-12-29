package com.hr.smvc.empPosDept;


import java.util.List;

public interface empPosDeptHistoryService{
	
	public List<empPosDeptHistory> getAllemp_pos_dept_historys(int pageno);

	public void addemp_pos_dept_historys(empPosDeptHistory epdh);
	/*empPosDeptHistory findById(long id);*/
	public void updateemp_pos_dept_historys(empPosDeptHistory epdh);
	public List<empPosDeptHistory> getEmp_pos_dept_historys(int emp_id);
	//public List<employee> findAllEmployees();
}