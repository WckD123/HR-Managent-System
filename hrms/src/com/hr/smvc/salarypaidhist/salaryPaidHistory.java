package com.hr.smvc.salarypaidhist;
import java.util.Date;

public class salaryPaidHistory{
	private int transaction_id;
	private int emp_id;
	private int amount_paid;
	private Date credit_date;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(int amount_paid) {
		this.amount_paid = amount_paid;
	}
	public Date getCredit_date() {
		return credit_date;
	}
	public void setCredit_date(Date credit_date) {
		this.credit_date = credit_date;
	}
	@Override
	public String toString() {
		return "salaryPaidHistory [transaction_id=" + transaction_id
				+ ", emp_id=" + emp_id + ", amount_paid=" + amount_paid
				+ ", credit_date=" + credit_date + "]";
	}










}