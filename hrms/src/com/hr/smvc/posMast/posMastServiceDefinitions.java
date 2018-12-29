package com.hr.smvc.posMast;

import com.hr.smvc.posMast.posMastService;

import java.sql.Connection;
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


@Service("pos_mastService")
@Transactional
@SuppressWarnings("all")
public class posMastServiceDefinitions implements posMastService {
	Statement pst ;
	ResultSet rst;
	Connection conn;

	//apmin module getAllpos_masts
	public List<posMast> getAllpos_masts(){

		List <posMast> pms = new ArrayList<posMast>();
		String query = "SELECT * FROM pos_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				posMast pm = new posMast();
				System.out.println("rst is : " +rst);
				pm.setPos_id(rst.getInt("pos_id"));
				pm.setPos_name(rst.getString("pos_name"));
				pms.add(pm);
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
		return pms;
	}

	public void addpos_masts(posMast pm){

		String query ="INSERT INTO pos_mast (pos_id,pos_name) VALUES (' "+ pm.getPos_id()+ "', '"+ pm.getPos_name()+"') " ;

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


	public void updatepos_masts(posMast pm){

		String query = "UPDATE pos_mast set pos_name = '"+pm.getPos_name()+"' where pos_id = '"+pm.getPos_id()+"'";
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

	private static List<posMast> pms;

	public posMast findById(long id){
		pms = getAllpos_masts();
		for(posMast pm : pms){
			if(pm.getPos_id() == id){
				return pm;
			}
		}

		return null;
	}
}
