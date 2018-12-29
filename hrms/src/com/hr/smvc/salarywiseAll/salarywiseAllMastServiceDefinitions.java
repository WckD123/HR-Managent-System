package com.hr.smvc.salarywiseAll;

import java.sql.Connection;
import com.hr.smvc.config.DBConfig;
import com.hr.smvc.salarywiseAll.salarywiseAllMastService;
//import com.hr.samvc.models.Book;

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


@Service("salarywise_all_mastService")
@Transactional
@SuppressWarnings("all")
public class salarywiseAllMastServiceDefinitions implements salarywiseAllMastService {

	Statement pst ;
	ResultSet rst;
	Connection conn;

	//asamin module getAllsalarywise_all_masts
	public List<salarywiseAllMast> getAllsalarywise_all_masts(){

		List <salarywiseAllMast> sams = new ArrayList<salarywiseAllMast>();
		String query = "SELECT * FROM salarywise_all_mast";
		try {
			conn = DBConfig.getConnection();
			pst = conn.createStatement();
			rst = pst.executeQuery(query);

			while(rst.next()){
				salarywiseAllMast sam = new salarywiseAllMast();
				sam.setAll_mast_id(rst.getInt("all_mast_id"));
				sam.setSalary_id(rst.getInt("salary_id"));
				sam.setDes_id(rst.getInt("des_id"));
				sam.setAllowance_amt(rst.getInt("allowance_amt"));
				sams.add(sam);
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
		return sams;
	}

	public void addsalarywise_all_masts(salarywiseAllMast sam){

		String query ="INSERT INTO salarywise_all_mast (salary_id,des_id,allowance_amt) VALUES (' "+ sam.getSalary_id()+ "', '"+ sam.getDes_id()+"', '"+ sam.getAllowance_amt()+"') " ;

		try {

			int i;
			Statement st= null;
			conn = DBConfig.getConnection();
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


	public void updatesalarywise_all_masts(salarywiseAllMast sam){

		String query = "UPDATE salarywise_all_mast set salary_id = '"+sam.getSalary_id()+"', des_id = '"+sam.getDes_id() +"', allowance_amt = '"+sam.getAllowance_amt() +"' where all_mast_id = '"+sam.getAll_mast_id()+"'";
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

	private static List<salarywiseAllMast> sams;

	public salarywiseAllMast findById(long id){
		sams = getAllsalarywise_all_masts();
		for(salarywiseAllMast sam : sams){
			if(sam.getSalary_id() == id){
				System.out.println("inside the InnerMostLoop of findById");
				return sam;
			}
		}

		return null;
	}
}
