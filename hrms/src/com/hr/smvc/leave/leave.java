package com.hr.smvc.leave;
import java.util.Date;

public class leave{
	private int leave_id;
	private int emp_id;
	private Date start_date;
	private Date end_date;
	@SuppressWarnings("deprecation")
	private Date approved_date = new Date(0000,00,00);
	private String status = "Applied";
	private String orderBy = "status";
	private String ordertype = "DESC";
	private int pageNo = 0;
	
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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
	public Date getApproved_date() {
		return approved_date;
	}
	public void setApproved_date(Date approved_date) {
		this.approved_date = approved_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "leave [leave_id=" + leave_id + ", emp_id=" + emp_id
				+ ", start_date=" + start_date + ", end_date=" + end_date
				+ ", approved_date=" + approved_date + ", status=" + status
				+ "]";
	}
	
}