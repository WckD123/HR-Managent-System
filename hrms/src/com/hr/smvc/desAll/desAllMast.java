package com.hr.smvc.desAll;

public class desAllMast{
	private int des_id;
	private int dept_id;
	private int pos_id;
	private String allowances;
	public int getDes_id() {
		return des_id;
	}
	public void setDes_id(int des_id) {
		this.des_id = des_id;
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
	public String getAllowances() {
		return allowances;
	}
	public void setAllowances(String allowances) {
		this.allowances = allowances;
	}
	@Override
	public String toString() {
		return "des_all_mast [des_id=" + des_id + ", dept_id=" + dept_id
				+ ", pos_id=" + pos_id + ", allowances=" + allowances + "]";
	}
	
}