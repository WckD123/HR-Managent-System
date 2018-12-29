package com.hr.smvc.salaryMast;

import java.sql.Connection;
import com.hr.smvc.config.DBConfig;
import com.hr.smvc.salaryMast.salaryMastService;
//import com.hr.smvc.models.Book;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;


@Service("salary_mastService")
@Transactional
@SuppressWarnings("all")
public class salaryMastServiceDefinitions implements salaryMastService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	//asmin module getAllsalary_masts
	public List<salaryMast> getAllsalary_masts(){

		List <salaryMast> sms = new ArrayList<salaryMast>();
		String query = "SELECT * FROM salary_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				salaryMast sm = new salaryMast();
				sm.setSalary_id(rst.getInt("salary_id"));
				sm.setEmp_id(rst.getInt("emp_id"));
				sm.setBase_id(rst.getInt("base_id"));
				sm.setDeductions(rst.getInt("deductions"));
				sms.add(sm);
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
		return sms;
	}

	public void addsalary_masts(salaryMast sm){

		String query ="INSERT INTO salary_mast (emp_id,base_id,deductions) VALUES (' "+ sm.getEmp_id()+ "', '"+ sm.getBase_id()+"', '"+ sm.getDeductions()+"') " ;

		try {
			conn = DBConfig.getConnection();
			int i;
			Statement st= null;
			st = conn.createStatement();
			i = st.executeUpdate(query);

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
	}


	public void updatesalary_masts(salaryMast sm){

		String query = "UPDATE salary_mast set emp_id = '"+sm.getEmp_id()+"', base_id = '"+sm.getBase_id() +"', deductions = '"+sm.getDeductions() +"' where salary_id = '"+sm.getSalary_id()+"'";
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

	private static List<salaryMast> sms;

	public salaryMast findById(long id){
		sms = getAllsalary_masts();
		for(salaryMast sm : sms){
			if(sm.getSalary_id() == id){
				return sm;
			}
		}

		return null;
	}
}
