package com.hr.smvc.attendance;


import java.sql.Date;
import java.util.List;

public interface attendanceService{
	
	public List<attendance> getAllattendances(int pageno);
	public List<java.sql.Date> getAttendanceById(int emp_id,int pageno );
//	public void addEmployees(employee emp);
	public void setAttendance(int emp_id);
	/*attendance findById(long id,int pageno);*/
	public void updateattendances(attendance atd);
	public Date getjoiningdate(int emp_id);
	//public List<employee> findAllEmployees();
}
