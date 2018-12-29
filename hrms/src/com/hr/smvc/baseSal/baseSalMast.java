package com.hr.smvc.baseSal;

public class baseSalMast{
	private int base_id;
	private int dept_id;
	private int pos_id;
	private int base_salary;
	private int leave_days;
	public int getBase_id() {
		return base_id;
	}
	public void setBase_id(int base_id) {
		this.base_id = base_id;
	}
	public int getDept_id() {
		return dept_id;
	}
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	public int getPos_id() {
		return pos_id;
	}
	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}
	public int getBase_salary() {
		return base_salary;
	}
	public void setBase_salary(int base_salary) {
		this.base_salary = base_salary;
	}
	public int getLeave_days() {
		return leave_days;
	}
	public void setLeave_days(int leave_days) {
		this.leave_days = leave_days;
	}
	@Override
	public String toString() {
		return "base_sal_mast [base_id=" + base_id + ", dept_id=" + dept_id
				+ ", pos_id=" + pos_id + ", base_salary=" + base_salary
				+ ", leave_days=" + leave_days + "]";
	}
	
}