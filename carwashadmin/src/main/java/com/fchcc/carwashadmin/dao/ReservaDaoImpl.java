package com.fchcc.carwashadmin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.fchcc.carwashadmin.model.Reserva;

@Repository
public class ReservaDaoImpl implements ReservaDAO {

	

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 
	 @Autowired
	 public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
	  this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	 }

	 
	@Override
	public List<Reserva> getAllReservas() {
		
		  String query = "SELECT * FROM Reserva";
	        List<Reserva> rev  = namedParameterJdbcTemplate.query(
	                query,
	                new ReservaMapper());
	        return rev ;
	}

	@Override
	public int save(Reserva r) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		 //DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss"); 
		 
		String query ="insert into Reserva (ServiceName, Fecha,Hora) values ( :serviceName, :Fecha, :Hora)";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
      paramMap.addValue("serviceName", r.getServiceName());
      paramMap.addValue("Fecha", r.getFecha());
      paramMap.addValue("Hora", r.getHora());
      // Passing map containing named params
      return namedParameterJdbcTemplate.update(query, paramMap);
		
	}

	@Override
	public Reserva getStudentById(int id) {
		String query = "select Id,ServiceName,Fecha,Hora from Reserva where Id = :Id";
		return this.namedParameterJdbcTemplate.queryForObject(query, new MapSqlParameterSource(
		           "Id", id), new ReservaMapper());
		    
	}

	@Override
	public void update(Reserva r) {
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		 //DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss"); 
		String query = "update Reserva set ServiceName = :serviceName, Fecha = :Fecha, Hora = :Hora where Id = :Id";
		  SqlParameterSource namedParameters = new MapSqlParameterSource()
				  .addValue("serviceName", r.getServiceName())
				  .addValue("Fecha", r.getFecha())
				  .addValue("Hora", r.getHora())
		  		  .addValue("Id", r.getId());
      int status = namedParameterJdbcTemplate.update(query, namedParameters); 
      if(status != 0){
          System.out.println("Reserva data updated for ID " + r.getId());
      }else{
          System.out.println("No Reserva found with ID " + r.getId());
      }

	}

	@Override
	public void delete(int id) {
		
		String query ="delete from Reserva where Id= :Id";
		
		 SqlParameterSource namedParameters = new MapSqlParameterSource("Id", id);
	        int status = namedParameterJdbcTemplate.update(query, namedParameters);
	        if(status != 0){
	            System.out.println("Reserva data deleted for ID " + id);
	        }else{
	            System.out.println("No Reserva found with ID " + id);
	        }

	}
	
	
	private static final class ReservaMapper implements RowMapper<Reserva> {
      public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
          
   	   Reserva rev = new Reserva();
   	   	rev.setId(rs.getInt("Id"));
   	   	rev.setServiceName(rs.getString("ServiceName"));
   	   	rev.setFecha(rs.getDate("Fecha"));
   	   	rev.setHora(rs.getTime("Hora"));
          return rev;
      }
  }



}