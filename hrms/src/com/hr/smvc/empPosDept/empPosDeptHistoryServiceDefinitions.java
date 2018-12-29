package com.hr.smvc.empPosDept;

import com.hr.smvc.config.DBConfig;
import com.hr.smvc.empPosDept.empPosDeptHistoryService;
//import com.hr.smvc.models.Book;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;




@Service("emp_pos_dept_historyService")
@Transactional
@SuppressWarnings("all")
public class empPosDeptHistoryServiceDefinitions implements empPosDeptHistoryService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	//admin module getAllEmployees
	public List<empPosDeptHistory> getAllemp_pos_dept_historys(int pageno){

		List <empPosDeptHistory> emps = new ArrayList<empPosDeptHistory>();
		String query = "SELECT * FROM emp_pos_dept_history LIMIT 100 OFFSET "+(pageno*100)+";";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				empPosDeptHistory epdh = new empPosDeptHistory();
				epdh.setPos_dep_hist_id(rst.getInt("pos_dep_hist_id"));
				epdh.setDept_id(rst.getInt("dept_id"));
				epdh.setPos_id(rst.getInt("pos_id"));
				epdh.setEmp_id(rst.getInt("emp_id"));
				epdh.setStart_date(rst.getDate("start_date"));
				epdh.setEnd_date(rst.getDate("end_date"));
				epdh.setStatus(rst.getString("status"));
				emps.add(epdh);
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

	public void addemp_pos_dept_historys(empPosDeptHistory epdh){
		java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
		String Start_date= new SimpleDateFormat("yyyy-MM-dd").format(now);
		
		//String End_date= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(epdh.getEnd_date());
		String query ="INSERT INTO emp_pos_dept_history (dept_id, pos_id ,emp_id ,start_date, status) VALUES (' "+ epdh.getDept_id()+ "', '"+ epdh.getPos_id()+"' , '"+ epdh.getEmp_id()+"' , '"+Start_date+"', '"+ epdh.getStatus()+"') " ;

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


	public void updateemp_pos_dept_historys(empPosDeptHistory epdh){

		String query = "UPDATE emp_pos_dept_history set dept_id = '"+epdh.getDept_id()+"' , pos_id = '"+epdh.getPos_id()+"' , emp_id = '"+epdh.getEmp_id()+"' , start_date = '"+epdh.getStart_date()+"' , end_date = '"+epdh.getEnd_date()+"' , status = '"+epdh.getStatus()+"' where pos_dep_hist_id = '"+epdh.getPos_dep_hist_id()+"'";
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

	private static List<empPosDeptHistory> epdhps;

	/*public empPosDeptHistory findById(long id){
		epdhps = getAllemp_pos_dept_historys();
		for(empPosDeptHistory epdh : epdhps){
			if(epdh.getPos_dep_hist_id() == id){
				return epdh;
			}
		}

		return null;
	}*/

	@Override
	public List<empPosDeptHistory> getEmp_pos_dept_historys(int emp_id){

		List <empPosDeptHistory> emps = new ArrayList<empPosDeptHistory>();
		String query = "SELECT * FROM emp_pos_dept_history WHERE emp_id ='"+emp_id+"';  ";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				empPosDeptHistory epdh = new empPosDeptHistory();
				epdh.setPos_dep_hist_id(rst.getInt("pos_dep_hist_id"));
				epdh.setDept_id(rst.getInt("dept_id"));
				epdh.setPos_id(rst.getInt("pos_id"));
				epdh.setEmp_id(rst.getInt("emp_id"));
				epdh.setStart_date(rst.getDate("start_date"));
				epdh.setEnd_date(rst.getDate("end_date"));
				epdh.setStatus(rst.getString("status"));
				emps.add(epdh);
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

}
