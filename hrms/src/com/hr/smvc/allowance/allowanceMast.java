package com.hr.smvc.allowance;

public class allowanceMast{
	private int allow_id;
	private String all_name;
	private int all_per;
	private int fixed_amt;
	
	public int getAllow_id() {
		return allow_id;
	}
	public void setAllow_id(int allow_id) {
		this.allow_id = allow_id;
	}
	public String getAll_name() {
		return all_name;
	}
	public void setAll_name(String all_name) {
		this.all_name = all_name;
	}
	public int getAll_per() {
		return all_per;
	}
	public void setAll_per(int all_per) {
		this.all_per = all_per;
	}
	public int getFixed_amt() {
		return fixed_amt;
	}
	public void setFixed_amt(int fixed_amt) {
		this.fixed_amt = fixed_amt;
	}
	@Override
	public String toString() {
		return "allowance_mast [allow_id=" + allow_id + ", all_name="
				+ all_name + ", all_per=" + all_per + ", fixed_amt="
				+ fixed_amt + "]";
	}
	
}