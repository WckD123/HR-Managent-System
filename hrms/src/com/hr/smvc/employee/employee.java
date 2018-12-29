package com.hr.smvc.employee;

public class employee{
	
	private int emp_id;
	private String full_name;
	private String qualification;
	private String address;
	private String mobile;
	private String pan_no;
	private String aadhar_no;
	private String marital_status;
	private java.sql.Date joining_date;
	private String photo;
	private String email_id;
	private String password = "tempPassword";
	private String role = "Emp";
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(String marital_status) {
		this.marital_status = marital_status;
	}
	public java.sql.Date getJoining_date() {
		return joining_date;
	}
	public void setJoining_date(java.sql.Date date) {
		this.joining_date = date;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	@Override
	public String toString() {
		return "employee [emp_id=" + emp_id + ", full_name=" + full_name
				+ ", qualification=" + qualification + ", address=" + address
				+ ", mobile=" + mobile + ", pan_no=" + pan_no + ", aadhar_no="
				+ aadhar_no + ", marital_status=" + marital_status
				+ ", joining_date=" + joining_date + ", photo=" + photo
				+ ", email_id=" + email_id + ", password=" + password + "]";
	}
	
}