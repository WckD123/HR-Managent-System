package com.hr.smvc.baseSal;

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
import java.sql.Connection;
import java.sql.Statement;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;

@Service("base_sal_mastService")
@Transactional
@SuppressWarnings("all")
public class baseSalMastServiceDefinitions implements baseSalMastService {


	Statement pst ;
	ResultSet rst;
	Connection conn;

	//admin module getAllEmployees
	public List<baseSalMast> getAllbase_sal_masts(){

		List <baseSalMast> emps = new ArrayList<baseSalMast>();
		String query = "SELECT * FROM base_sal_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				baseSalMast bsm = new baseSalMast();
				bsm.setBase_id(rst.getInt("base_id"));
				bsm.setDept_id(rst.getInt("dept_id"));
				bsm.setPos_id(rst.getInt("pos_id"));
				bsm.setBase_salary(rst.getInt("base_salary"));
				bsm.setLeave_days(rst.getInt("leave_days"));
				emps.add(bsm);
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

	public void addbase_sal_masts(baseSalMast bsm){

		String query ="INSERT INTO base_sal_mast (dept_id, pos_id ,base_salary , leave_days) VALUES (' "+ bsm.getDept_id()+ "', '"+ bsm.getPos_id()+"' , '"+ bsm.getBase_salary()+"' , '"+ bsm.getLeave_days()+ "') " ;

		try {
			int i;
			conn = DBConfig.getConnection();
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


	public void updatebase_sal_masts(baseSalMast bsm){

		String query = "UPDATE base_sal_mast set dept_id = '"+bsm.getDept_id()+"' , pos_id = '"+bsm.getPos_id()+"' , base_salary = '"+bsm.getBase_salary()+"', leave_days = '"+ bsm.getLeave_days()+"' where allow_id = '"+bsm.getBase_id()+"'";
		try {
			int i;
			conn = DBConfig.getConnection();
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

	private static List<baseSalMast> bsmps;

	public baseSalMast findById(long id){
		bsmps = getAllbase_sal_masts();
		for(baseSalMast bsm : bsmps){
			if(bsm.getBase_id() == id){
				return bsm;
			}
		}

		return null;
	}
}
