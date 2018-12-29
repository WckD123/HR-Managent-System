package com.hr.smvc.login;

import java.sql.Connection;
import com.hr.smvc.config.DBConfig;
import com.hr.smvc.employee.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.hr.smvc.models.*;

//Changed by Gopi

@Service("loginService")
@Transactional
@SuppressWarnings("all")
public class loginServiceDefinitions implements loginService {

	private static ArrayList<employee> emps ;
	Statement pst ;
	ResultSet rst;
	Connection conn;

	public employee findByEmail(String email) {
		String query ="SELECT * FROM employee WHERE email_id ='"+email+"'; " ;
		boolean i;
		employee emp = new employee();
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			
			rst = pst.executeQuery(query);
			rst.next();
			emp.setFull_name(rst.getString("full_name"));
			emp.setQualification(rst.getString("qualification"));
			emp.setAddress(rst.getString("address"));
			emp.setMobile(rst.getString("mobile"));
			emp.setPan_no(rst.getString("pan_no"));
			emp.setAadhar_no(rst.getString("aadhar_no"));
			emp.setMarital_status(rst.getString("marital_status"));
			emp.setJoining_date(rst.getDate("joining_date"));
			emp.setPhoto(rst.getString("photo"));
			emp.setEmail_id(rst.getString("email_id"));
			emp.setPassword(rst.getString("password"));
			emp.setRole(rst.getString("role"));


		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return emp;
	}

/*	public employee findByID(int emp_id) {
		emps = findAllEmployees() ;
		for(employee emp : emps) {
			if(emp.getEmp_id() == emp_id) {
				return emp ;
			}
		}
		return null ;
	}*/

	public employee findById(int id){
		String query ="SELECT * FROM employee WHERE emp_id ='"+id+"'" ;

		employee emp = new employee();
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			rst.next();
			emp.setEmp_id(rst.getInt("emp_id"));
			emp.setFull_name(rst.getString("full_name"));
			emp.setQualification(rst.getString("qualification"));
			emp.setAddress(rst.getString("address"));
			emp.setMobile(rst.getString("mobile"));
			emp.setPan_no(rst.getString("pan_no"));
			emp.setAadhar_no(rst.getString("aadhar_no"));
			emp.setMarital_status(rst.getString("marital_status"));
			emp.setJoining_date(rst.getDate("joining_date"));
			emp.setPhoto(rst.getString("photo"));
			emp.setEmail_id(rst.getString("email_id"));
			emp.setPassword(rst.getString("password"));
			emp.setRole(rst.getString("role"));
			return emp;


		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	public ArrayList<employee> findAllEmployees() {
		emps = new ArrayList<employee>();
		try {
			String query = "SELECT * from employee" ;
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query) ;
			while(rst.next()){
				employee emp = new employee();
				emp.setEmp_id(rst.getInt("emp_id"));
				emp.setFull_name(rst.getString("full_name"));
				emp.setQualification(rst.getString("qualification"));
				emp.setAddress(rst.getString("address"));
				emp.setMobile(rst.getString("mobile"));
				emp.setPan_no(rst.getString("pan_no"));
				emp.setAadhar_no(rst.getString("aadhar_no"));
				emp.setMarital_status(rst.getString("marital_status"));
				emp.setJoining_date(rst.getDate("joining_date"));
				emp.setPhoto(rst.getString("photo"));
				emp.setEmail_id(rst.getString("email_id"));
				emp.setPassword(rst.getString("password"));
				emp.setRole(rst.getString("role"));
				emps.add(emp);
				return emps;
			}
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  null;
	}
}
