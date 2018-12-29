package com.hr.smvc.posMast;

public class posMast{
	private int pos_id;
	private String pos_name;
	public int getPos_id() {
		return pos_id;
	}
	public void setPos_id(int pos_id) {
		this.pos_id = pos_id;
	}
	public String getPos_name() {
		return pos_name;
	}
	public void setPos_name(String pos_name) {
		this.pos_name = pos_name;
	}
	@Override
	public String toString() {
		return "pos_mast [pos_id=" + pos_id + ", pos_name=" + pos_name + "]";
	}
	
	
}