package com.fchcc.carwashadmin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;


import com.fchcc.carwashadmin.model.Users;

public class UsersDAO {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
	}
	
	public	Users getUser(int Id, String pass) {
		
		return template.query("select * from Users where Id='"+Id+"' and password='"+pass+"'",new ResultSetExtractor<Users>(){
				
			public Users extractData(ResultSet rs ) throws SQLException, DataAccessException{
				
				Users u = new Users();
				
				while(rs.next()){  
			   
			        u.setUserName(rs.getString(1));
			        u.setPassword(rs.getString(2));
			        u.setName(rs.getString(3));
			       
			        }  
				return u;
			}
		
	});
}
	
}
