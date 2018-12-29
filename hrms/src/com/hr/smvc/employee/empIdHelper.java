package com.hr.smvc.employee;

public class empIdHelper {
	private int emp_id;
	private String full_name;
	private String role;
	private int pageno;





	public void setPageno(int pageno) {
		this.pageno = pageno;
	}




	public String getRole() {
		return role;
	}




	public String getFull_name() {
		return full_name;
	}


	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "empIdHelper [emp_id=" + emp_id + ", full_name=" + full_name
				+ "]";
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
		
	}


	public void setRole(String role) {
		// TODO Auto-generated method stub
		this.role = role;
	}




	public int getPageno() {
		// TODO Auto-generated method stub
		return pageno;
	}
	
}