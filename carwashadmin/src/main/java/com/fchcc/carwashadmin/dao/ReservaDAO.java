package com.fchcc.carwashadmin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fchcc.carwashadmin.model.Reserva;

public class ReservaDAO {

		JdbcTemplate template;
		
		public void setTemplate(JdbcTemplate template) {
			this.template=template;
		}
		
		public void save(Reserva r) {
			
			String r1 = ConvertDate(r.getFecha());
			String r2 = ConvertHora(r.getHora());
			System.out.println(r1);
			System.out.println(r2);
			String sql = "insert into Reserva(ServiceName,Fecha,Hora) values ('"+r.getServiceName()+"','"+r1+"','"+r2+"')";
			System.out.println(sql);
			template.update(sql);
		}
		
		public List<Reserva> getAllReservas(){
			return template.query("select * from Reserva",new ResultSetExtractor<List<Reserva>>(){  
			    
			     public List<Reserva> extractData(ResultSet rs) throws SQLException,  
			            DataAccessException {  
			      
			        List<Reserva> list=new ArrayList<Reserva>();  
			        while(rs.next()){  
			        Reserva r=new Reserva();  
			        r.setId(rs.getInt(1));  
			        r.setServiceName(rs.getString(2));  
			        r.setFecha(rs.getDate(3));
			        r.setHora(rs.getDate(4));
			        list.add(r);  
			        }  
			        return list;  
			        }

				
			    });  
			  
			
			  }
		
		
		public Reserva getStudentById(int id) {
			return template.query("select * from Reserva where Id = "+id,new ResultSetExtractor<Reserva>(){
				
				
				public Reserva extractData(ResultSet rs ) throws SQLException, DataAccessException{
					
					Reserva r = new Reserva();
					
					while(rs.next()){  
				        
				        r.setId(rs.getInt(1));  
				        r.setServiceName(rs.getString(2));  
				        r.setFecha(rs.getDate(3));
				        r.setHora(rs.getDate(4));
				       
				        }  
					return r;
				}
			});
		}
		
		
		
		
		
		public void update(Reserva r) {
			String sql="update Reserva set ServiceName='"+r.getServiceName()+"',Fecha='"+ConvertDate(r.getFecha())+"',Hora='"+ConvertHora(r.getHora())+"' where Id="+r.getId()+"";
			System.out.println(sql);
	       template.update(sql);  
		}
		
		
		public void delete(int id) {
			// TODO Auto-generated method stub
			String sql="delete from Reserva where Id="+id+"";  
		    template.update(sql);  
			
		}


		private String ConvertHora(Date hora) {
			  System.out.println("CONVERTHORAINPROCESS");
			 String formatedDate ="";
			    try {
			    	DateFormat formatter = new SimpleDateFormat("hh:mm:ss");
			    	 hora = (Date) formatter.parse(hora.toString());
			       System.out.println(hora);
					Calendar cal = Calendar.getInstance();
					   
					    cal.setTime(hora);
					    
					    formatedDate=cal.get(Calendar.HOUR)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
			   ;
			    return formatedDate;
			}	
		

		private String ConvertDate(Date fecha) {
			  System.out.println("CONVERDATEINPROCESS");
			 String formatedDate ="";
		    try {
		    	DateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
				fecha = (Date)formatter.parse(fecha.toString());
				System.out.println(fecha);
				 Calendar cal = Calendar.getInstance();
				   
				    cal.setTime(fecha);
				       
				    formatedDate=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DATE);
				   
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   
		    
		    return formatedDate;
		}
		
}
