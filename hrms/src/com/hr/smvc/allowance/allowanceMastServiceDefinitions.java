package com.hr.smvc.allowance;

import com.hr.smvc.allowance.allowanceMastService;
import com.hr.smvc.config.DBConfig;
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

@Service("allowance_mastService")
@Transactional
@SuppressWarnings("all")
public class allowanceMastServiceDefinitions implements allowanceMastService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	//admin module getAllEmployees
	public List<allowanceMast> getAllAllowances(){
		List <allowanceMast> emps = new ArrayList<allowanceMast>();
		String query = "SELECT * FROM allowance_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				allowanceMast am = new allowanceMast();
				am.setAllow_id(rst.getInt("allow_id"));
				am.setAll_name(rst.getString("all_name"));
				am.setAll_per(rst.getInt("all_per"));
				am.setFixed_amt(rst.getInt("fixed_amt"));
				emps.add(am);
			}

		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if (!conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emps;
	}

	public void addAllowances(allowanceMast am){

		String query ="INSERT INTO allowance_mast (all_name, all_per , fixed_amt) VALUES (' "+ am.getAll_name()+ "', '"+ am.getAll_per()+"' , '"+ am.getFixed_amt()+ "') " ;

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


	public void updateAllowances(allowanceMast am){

		String query = "UPDATE allowance_mast set all_name = '"+am.getAll_name()+"' , all_per = '"+am.getAll_per()+"' , fixed_amt = '"+am.getFixed_amt()+"' where allow_id = '"+am.getAllow_id()+"'";
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

	private static List<allowanceMast> amps;

	public allowanceMast findById(long id){
		amps = getAllAllowances();
		for(allowanceMast am : amps){
			if(am.getAllow_id() == id){
				return am;
			}
		}

		return null;
	}


}
