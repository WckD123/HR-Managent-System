package com.hr.smvc.attendance;
import java.util.Date;

public class attendance{
	private int att_id;
	private int emp_id;
	private Date att_date;
	private int pageno;
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getAtt_id() {
		return att_id;
	}
	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public Date getAtt_date() {
		return att_date;
	}
	public void setAtt_date(Date date) {
		this.att_date = date;
	}
	@Override
	public String toString() {
		return "attendance [att_id=" + att_id + ", emp_id=" + emp_id
				+ ", date=" + att_date + "]";
	}
	
}