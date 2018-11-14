package com.fchcc.carwashadmin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.fchcc.carwashadmin.model.Users;


@Repository
public class UsersDaoImpl implements UsersDAO {

	 NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	@Override
	public Users findUserInfoByUserName(String userName) {
		  String query = "select * from Users where userName= userName";
		  
		  try{
		   Users users = namedParameterJdbcTemplate.queryForObject(query, getSqlParameterByModel(userName, ""), new UsersMapper());
		   return users;
		  }
		  catch(EmptyResultDataAccessException e){
		   e.printStackTrace();
		  }
		  catch (Exception e) {
		   e.printStackTrace();
		  }
		  return null;
	}

	private SqlParameterSource getSqlParameterByModel(String userName, String password) {

		  MapSqlParameterSource paramSource = new MapSqlParameterSource();
		  paramSource.addValue("userName", userName);
		  paramSource.addValue("password", password);
		  return paramSource;
	}
	
	private static final class UsersMapper implements RowMapper<Users>{
		  
		  public Users mapRow(ResultSet rs, int rowNum) throws SQLException{
		  
			  String userName = rs.getString("userName");
			   String password = rs.getString("password");
			   return new Users(userName, password);
		  }
		 }

	@Override
	public List<String> getUserRolesByUserName(String userName) {
		  String query = "select user_role from user_roles WHERE userName=userName";
		  List<String> roles = namedParameterJdbcTemplate.queryForList(query, getSqlParameterByModel(userName, ""), String.class);
		  return roles;
	}
	
}