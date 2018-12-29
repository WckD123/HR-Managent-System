package com.hr.smvc.desAll;

import com.hr.smvc.config.DBConfig;
import com.hr.smvc.desAll.desAllMastService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.ArrayList;



@Service("des_all_mastService")
@Transactional
@SuppressWarnings("all")
public class desAllMastServiceDefinitions implements desAllMastService {
	Statement pst ;
	ResultSet rst;
	Connection conn;

	//admin module getAllEmployees
	public List<desAllMast> getAlldes_all_masts(){

		List <desAllMast> emps = new ArrayList<desAllMast>();
		String query = "SELECT * FROM des_all_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				desAllMast dam = new desAllMast();
				dam.setDes_id(rst.getInt("des_id"));
				dam.setDept_id(rst.getInt("dept_id"));
				dam.setPos_id(rst.getInt("pos_id"));
				dam.setAllowances(rst.getString("des_all_masts"));
				emps.add(dam);
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

	public void adddes_all_masts(desAllMast dam){

		String query ="INSERT INTO des_all_mast (dept_id, pos_id ,allowances) VALUES (' "+ dam.getDept_id()+ "', '"+ dam.getPos_id()+"' , '"+ dam.getAllowances()+"') " ;

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


	public void updatedes_all_masts(desAllMast dam){

		String query = "UPDATE des_all_mast set dept_id = '"+dam.getDept_id()+"' , pos_id = '"+dam.getPos_id()+"' , allowances = '"+dam.getAllowances()+"' where allow_id = '"+dam.getDes_id()+"'";
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

	private static List<desAllMast> damps;

	public desAllMast findById(long id){
		damps = getAlldes_all_masts();
		for(desAllMast dam : damps){
			if(dam.getDes_id() == id){
				return dam;
			}
		}

		return null;
	}
}
