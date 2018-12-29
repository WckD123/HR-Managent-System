package com.hr.smvc.salaryMast;

public class salaryMast{
	private int salary_id;
	private int emp_id;
	private int base_id;
	private int deductions;
	public int getSalary_id() {
		return salary_id;
	}
	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getBase_id() {
		return base_id;
	}
	public void setBase_id(int base_id) {
		this.base_id = base_id;
	}
	public int getDeductions() {
		return deductions;
	}
	public void setDeductions(int deductions) {
		this.deductions = deductions;
	}
	@Override
	public String toString() {
		return "employee [salary_id=" + salary_id + ", emp_id=" + emp_id
				+ ", base_id=" + base_id + ", deductions=" + deductions + "]";
	}
	
}