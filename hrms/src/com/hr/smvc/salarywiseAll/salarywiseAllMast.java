package com.hr.smvc.salarywiseAll;

public class salarywiseAllMast{
	
	private int all_mast_id;
	private int salary_id;
	private int des_id;
	private int allowance_amt;
	
	public int getAllowance_amt() {
		return allowance_amt;
	}
	public void setAllowance_amt(int allowance_amt) {
		this.allowance_amt = allowance_amt;
	}
	public int getAll_mast_id() {
		return all_mast_id;
	}
	public void setAll_mast_id(int all_mast_id) {
		this.all_mast_id = all_mast_id;
	}
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}
	public int getDes_id() {
		return des_id;
	}
	public void setDes_id(int des_id) {
		this.des_id = des_id;
	}
	@Override
	public String toString() {
		return "salarywise_all_mast [all_mast_id=" + all_mast_id
				+ ", salary_id=" + salary_id + ", allowance_id=" + des_id
				+ ", allowance_amt=" + allowance_amt + "]";
	}
	
}