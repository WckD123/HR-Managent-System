package com.hr.smvc.deptMast;

import com.hr.smvc.config.DBConfig;
import com.hr.smvc.deptMast.deptMastService;
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
import java.sql.Connection;
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

@Service("dept_mastService")
@Transactional
@SuppressWarnings("all")
public class deptMastServiceDefinitions implements deptMastService {

	Statement pst ;
	ResultSet rst;
	Connection conn;
	//admin module getAlldept_masts
	public List<deptMast> getAlldept_masts(){

		List <deptMast> dms = new ArrayList<deptMast>();
		String query = "SELECT * FROM dept_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				deptMast dm = new deptMast();
				dm.setDept_id(rst.getInt("dept_id"));
				dm.setDept_name(rst.getString("dept_name"));
				dms.add(dm);
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
		return dms;
	}

	public void adddept_masts(deptMast dm){

		String query ="INSERT INTO dept_mast (dept_id,dept_name) VALUES (' "+ dm.getDept_id()+ "', '"+ dm.getDept_name()+"') " ;

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


	public void updatedept_masts(deptMast dm){

		String query = "UPDATE dept_mast set dept_name = '"+dm.getDept_name()+"' where dept_id = '"+dm.getDept_id()+"'";
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

	private static List<deptMast> dms;

	public deptMast findById(long id){
		dms = getAlldept_masts();
		for(deptMast dm : dms){
			if(dm.getDept_id() == id){
				return dm;
			}
		}

		return null;
	}

}
