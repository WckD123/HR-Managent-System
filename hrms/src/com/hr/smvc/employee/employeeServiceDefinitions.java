package com.hr.smvc.employee;

//import com.hr.smvc.models.Book;
import java.sql.Connection;
import com.hr.smvc.config.DBConfig;
import com.hr.smvc.employee.employeeService;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;

@Service("employeeService")
@Transactional
@SuppressWarnings("all")
public class employeeServiceDefinitions implements employeeService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	//admin module getAllEmployees
	public List<employee> getAllEmployees(int pageno){

		List <employee> emps = new ArrayList<employee>();
		String query = "SELECT * FROM employee ORDER BY emp_id LIMIT 10 OFFSET "+(pageno*10)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

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
				emps.add(emp);
			}

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
		return emps;
	}

	public Integer addEmployees(employee emp){
		empIdHelper empH = new empIdHelper();
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		String joiningDateStr= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
		employee emp1=new employee();
		String query ="INSERT INTO employee ( full_name, qualification , address, mobile, pan_no, aadhar_no, marital_status,joining_date,photo,email_id,role) VALUES (' "+ emp.getFull_name()+ "', '"+ emp.getQualification()+"' , '"+ emp.getAddress()+"' , '"+ emp.getMobile()+"' , '"+ emp.getPan_no()+"' , '"+ emp.getAadhar_no()+"', '"+ emp.getMarital_status()+"', '"+ joiningDateStr+ "','"+ emp.getPhoto()+"', '"+ emp.getEmail_id()+"' , ' "+ emp.getRole()+"') " ;
		String qry =  "SELECT max(emp_id) FROM employee";
		try {
			conn = DBConfig.getConnection();
			Statement st= null;
			st = conn.createStatement();
			int i = st.executeUpdate(query);
			System.out.println(i);
			if(i>0){
				pst = conn.createStatement();
				rst = pst.executeQuery(qry);
				rst.next();
				emp1.setEmp_id(rst.getInt(1));
				return emp1.getEmp_id();
				
			}
			/*
			 * conn=DBConfig.getConnection();
			String query = "INSERT INTO employee " +
					"(full_name, qualification , address, mobile, pan_no, aadhar_no, marital_status ," +
					"joining_date,photo,email_id,password,role)" +
					" VALUES " +
					"(?,?,?,?,?,?,?,?,?,?,?,?) " ;
			pst = conn.prepareStatement(query);
			pst.setString(1, emp.getFull_name());
			pst.setString(2, emp.getQualification());
			pst.setString(3, emp.getAddress());
			pst.setString(4, emp.getMobile());
			pst.setString(5, emp.getPan_no());
			pst.setString(6, emp.getAadhar_no());
			pst.setString(7, emp.getMarital_status());
			pst.setString(8, joiningDateStr);
			pst.setString(9, emp.getPhoto());
			pst.setString(10, emp.getEmail_id());
			pst.setString(11, emp.getPassword());
			pst.setString(12, emp.getRole());
			
			ResultSet rst = pst.executeUpdate();emp1.setEmp_id(emp.getEmp_id());*/

			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				//empH = getIdByEmail(emp.getEmail_id());
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		}
		return  emp1.getEmp_id();
	}


	public void updateEmployees(employee emp){

		String query = "UPDATE employee SET full_name = '"+emp.getFull_name()+"' , qualification = '"+emp.getQualification()+"' , address = '"+emp.getAddress()+"' , mobile = '"+emp.getMobile()+"' , pan_no = '"+emp.getPan_no()+"' , aadhar_no = '"+emp.getAadhar_no()+"' , marital_status = '"+emp.getMarital_status()+"' , joining_date = '"+emp.getJoining_date()+"', photo = '"+emp.getPhoto()+"' , email_id = '"+emp.getEmail_id()+"' , password = '"+emp.getPassword()+"' WHERE emp_id = '"+emp.getEmp_id()+"'";
		try {
			conn = DBConfig.getConnection();
			int i;
			Statement st=null;
			st=conn.createStatement();
			i=st.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void updateEmployeesemail(employee emp){

		String query = "UPDATE employee SET email_id = '"+emp.getEmail_id()+"' WHERE emp_id = '"+emp.getEmp_id()+"'";
		try {
			conn = DBConfig.getConnection();
			int i;
			Statement st=null;
			st=conn.createStatement();
			i=st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	public void updateEmployeesmob(employee emp){

		String query = "UPDATE employee SET mobile = '"+emp.getMobile()+"' WHERE emp_id = '"+emp.getEmp_id()+"'";
		try {
			conn = DBConfig.getConnection();
			int i;
			Statement st=null;
			st=conn.createStatement();
			i=st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	public void updateEmployeesadd(employee emp){

		String query = "UPDATE employee SET address = '"+emp.getAddress()+"' WHERE emp_id = '"+emp.getEmp_id()+"'";
		try {
			conn = DBConfig.getConnection();
			int i;
			Statement st=null;
			st=conn.createStatement();
			i=st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	public void updateEmployeesms(employee emp){

		String query = "UPDATE employee SET marital_status = '"+emp.getMarital_status()+"' WHERE emp_id = '"+emp.getEmp_id()+"'";
		try {
			conn = DBConfig.getConnection();
			int i;
			Statement st=null;
			st=conn.createStatement();
			i=st.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

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


	public empIdHelper getIdByEmail(String email){
		empIdHelper empH = new empIdHelper();
		String query =  "SELECT * FROM employee WHERE email_id = '"+email+"'  ";

		int id = 0;
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			rst.next();
			empH.setEmp_id(rst.getInt("emp_id"));
			System.out.println(rst.getInt("emp_id"));
			empH.setFull_name(rst.getString("full_name"));
			System.out.println(rst.getInt("emp_id"));
			empH.setRole(rst.getString("role"));
			return empH;
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
	
}
