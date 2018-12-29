package com.hr.smvc.leave;

import com.hr.smvc.leave.leaveService;

import java.sql.Connection;
import com.hr.smvc.config.DBConfig;
//import com.hr.smvc.models.Book;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;



@Service("leaveService")
@Transactional
@SuppressWarnings("all")
public class leaveServiceDefinitions implements leaveService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	//admin module getAllEmployees
	public List<leave> getAllleaves(int pageno){

		List <leave> lss = new ArrayList<leave>();
		String query = "SELECT * FROM leaves LIMIT 100 OFFSET "+(pageno*100)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				leave ls = new leave();
				ls.setLeave_id(rst.getInt("leave_id"));
				ls.setEmp_id(rst.getInt("emp_id"));
				ls.setStart_date(rst.getDate("start_date"));
				ls.setEnd_date(rst.getDate("end_date"));
				ls.setApproved_date(rst.getDate("approved_date"));
				ls.setStatus(rst.getString("status"));
				lss.add(ls);
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
		return lss;
	}
	public List<leave> getAppleaves(){

		List <leave> lss = new ArrayList<leave>();
		String query = "SELECT * FROM leaves where status = 'Applied'";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				leave ls = new leave();
				ls.setLeave_id(rst.getInt("leave_id"));
				ls.setEmp_id(rst.getInt("emp_id"));
				ls.setStart_date(rst.getDate("start_date"));
				ls.setEnd_date(rst.getDate("end_date"));
				ls.setApproved_date(rst.getDate("approved_date"));
				ls.setStatus(rst.getString("status"));
				lss.add(ls);
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
		return lss;
	}
	public List<leave> getaprleaves(leave b){

		List <leave> lss = new ArrayList<leave>();
		String query = "SELECT * FROM leaves where emp_id = "+ b.getEmp_id()+" ORDER BY "+b.getOrderBy()+" "+b.getOrdertype()+" LIMIT 100 OFFSET "+(b.getPageNo()*100)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				leave ls = new leave();
				ls.setLeave_id(rst.getInt("leave_id"));
				ls.setEmp_id(rst.getInt("emp_id"));
				ls.setStart_date(rst.getDate("start_date"));
				ls.setEnd_date(rst.getDate("end_date"));
				ls.setApproved_date(rst.getDate("approved_date"));
				ls.setStatus(rst.getString("status"));
				lss.add(ls);
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
		return lss;
	}
	public void addleaves(leave l){
		String Start_date = new SimpleDateFormat("yyyy-MM-dd").format(l.getStart_date());
		String End_date = new SimpleDateFormat("yyyy-MM-dd").format(l.getEnd_date());
		String Approved_date= new SimpleDateFormat("yyyy-MM-dd").format(l.getApproved_date());
		String query = "INSERT INTO leaves (emp_id,start_date,end_date,approved_date,status) VALUES (' "+ l.getEmp_id()+"' , '"+ Start_date +"' , '"+ End_date +"' , '"+ Approved_date +"' , '"+ l.getStatus()+"') " ;

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


	public void updateleaves(leave l){

		String query = "UPDATE leaves set emp_id = '"+l.getEmp_id()+"' , start_date = '"+l.getStart_date()+"' , end_date = '"+l.getEnd_date()+"' , approved_date = '"+l.getApproved_date()+"' , status = '"+l.getStatus()+"' where leave_id = '"+l.getLeave_id()+"'";
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

	private static List<leave> lps;

	/*public leave findById(long id){
		lps = getAllleaves();
		for(leave l : lps){
			if(l.getLeave_id() == id){
				return l;
			}
		}

		return null;
	}*/

	@Override
	public int getRemainingLeaveDays(int emp_id) {

		//List <leave> emps = new ArrayList<leave>();
		int lleft=0;
		String query = "SELECT " +
				"(leave_days-Sum(Datediff(l.end_date,l.start_date))) " +
				"AS lleft " +
				"FROM leaves l " +
				"JOIN salary_mast s ON s.emp_id = l.emp_id " +
				"JOIN base_sal_mast b on b.base_id = s.base_id " +
				"WHERE l.status='Approved' GROUP BY l.emp_id HAVING l.emp_id= '"+ emp_id + "'";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			rst.next();
			lleft=rst.getInt(1);


		} catch (SQLException e){
			e.printStackTrace();
			//return 22;
		} finally {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lleft;
	}


}
