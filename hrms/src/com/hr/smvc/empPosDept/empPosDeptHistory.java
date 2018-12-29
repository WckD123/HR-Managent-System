package com.hr.smvc.empPosDept;
import java.util.Date;

public class empPosDeptHistory{
	private int pos_dep_hist_id;
	private int emp_id;
	private int pos_id;
	private int dept_id;
	private Date start_date;
	private Date end_date;
	private String status = "Active";
	public int getPos_dep_hist_id() {
		return pos_dep_hist_id;
	}
	public void setPos_dep_hist_id(int pos_dep_hist_id) {
		this.pos_dep_hist_id = pos_dep_hist_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getPos_id() {
		return pos_id;
	}
	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "emp_pos_dept_history [pos_dep_hist_id=" + pos_dep_hist_id
				+ ", emp_id=" + emp_id + ", pos_id=" + pos_id + ", dept_id="
				+ dept_id + ", start_date=" + start_date + ", end_date="
				+ end_date + ", status=" + status + "]";
	}
	
	
}