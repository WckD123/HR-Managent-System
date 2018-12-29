package com.hr.smvc.attendance;

import com.hr.smvc.attendance.attendanceService;
import com.hr.smvc.config.DBConfig;
import com.hr.smvc.employee.employee;
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

import java.sql.Connection;
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


@Service("attendanceService")
@Transactional
@SuppressWarnings("all")
public class attendanceServiceDefinitions implements attendanceService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	public List<java.sql.Date> getAttendanceById(int emp_id,int pageno){
		List<java.sql.Date> att_Dates = new ArrayList<java.sql.Date>();
		String query = "SELECT att_date FROM attendance WHERE emp_id =  '"+emp_id+"' ORDER BY att_date LIMIT 100 OFFSET "+(100*pageno)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);
			while(rst.next()){
				java.sql.Date att_Date;
				att_Date = rst.getDate("att_date");
				att_Dates.add(att_Date);
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
		return att_Dates;
	}

	//admin module getAllattendances
	public List<attendance> getAllattendances(int pageno){
		List <attendance> atds = new ArrayList<attendance>();
		String query = "SELECT * FROM attendance ORDER BY att_date LIMIT 100 OFFSET "+(pageno*100)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				attendance atd = new attendance();
				atd.setAtt_id(rst.getInt("att_id"));
				atd.setEmp_id(rst.getInt("emp_id"));
				atd.setAtt_date(rst.getDate("att_date"));

				atds.add(atd);
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
		return atds;
	}

	public void setAttendance(int emp_id){
		int count=0;
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		String atdDate= new SimpleDateFormat("yyyy-MM-dd").format(now);
		String query ="INSERT INTO attendance (emp_id,att_date) VALUES ('"+ emp_id+"' , '"+ atdDate+"') " ;
		String qry = "SELECT COUNT(emp_id) FROM attendance WHERE att_date = '"+atdDate+"'AND emp_id = '"+emp_id+"';";


		try {
			int i;
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst= pst.executeQuery(qry);
			rst.next();
			count = rst.getInt(1);

			if(count==0){
				Statement st= null;
				st = conn.createStatement();
				i = st.executeUpdate(query);
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
	}


	public void updateattendances(attendance atd){

		String query = "UPDATE attendance set emp_id = '"+atd.getEmp_id()+"' , att_date = '"+atd.getAtt_date()+"' where att_id = '"+atd.getAtt_id()+"'";
		try {
			int i;
			Statement st=null;
			conn = DBConfig.getConnection();
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



	/*	private static List<attendance> atds;
	 * public List<attendance> findById(long id,int pageno){
		List <attendance> atds = new ArrayList<attendance>();
		String query = "SELECT * FROM attendance where emp_id = '"+id+"' LIMIT 100 OFFSET "+(pageno*100)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				attendance atd = new attendance();
				atd.setAtt_id(rst.getInt("att_id"));
				atd.setEmp_id(rst.getInt("emp_id"));
				atd.setAtt_date(rst.getDate("att_date"));

				atds.add(atd);
				
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
		return atds;
		}
*/
	public Date getjoiningdate(int emp_id){
		Date d = null;
		String query = "SELECT joining_date FROM employee where emp_id = '"+emp_id+"'";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			rst.next();
			d = rst.getDate("joining_date");

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
		return d;
	}
}
