package com.hr.smvc.login;

//changed by Gopi

public class loginHelper {
	private String email_id;
	private String emp_password;
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getEmp_password() {
		return emp_password;
	}
	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}
	@Override
	public String toString() {
		return "loginHelper [email_id=" + email_id + ", emp_password="
				+ emp_password + "]";
	}
	
}