package reserva;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import login.ConnectionProvider;
import reserva.ReservaDAO;
import reserva.Reserva;


public class ReservaDAOImpl implements ReservaDAO {

	
	static Connection conn;
	static PreparedStatement ps;
	
	@Override
	public void addReserva(Reserva r) {
		
		try {
			conn=ConnectionProvider.getConnection();
			ps= conn.prepareStatement("insert into Reserva values(?,?,?)");
			ps.setString(2, r.getServiceName());
			ps.setDate(3, r.getFecha());
			ps.setTime(4, r.getHora());
			
			ps.executeUpdate();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void editReserva(Reserva r) {
			
		try {
			
			conn= ConnectionProvider.getConnection();
			ps=conn.prepareStatement("update Reserva set ServiceName=?, fecha=?, hora=?");
			ps.setString(2, r.getServiceName());
			ps.setDate(3, r.getFecha());
			ps.setTime(4, r.getHora());
			
			ps.executeUpdate();
			conn.close();
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deleteReserva(Reserva r) {
		
		try {
			conn = ConnectionProvider.getConnection();
			ps=conn.prepareStatement("delete from Reserva where IdReserva='"+ r.getIdReserva() +"'");
			
			ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	@Override
	public Reserva getReserva(String idReserva) {
		
		Reserva reserva = new Reserva();
		try {
			
			conn = ConnectionProvider.getConnection();
			ps=conn.prepareStatement("select * from Reserva where IdReserva='"+idReserva+"'");
			System.out.println(ps);
			
			ResultSet rs =  ps.executeQuery();
			
			if(rs.next()) {
				reserva.setIdReserva(rs.getInt("IdReserva"));
				reserva.setServiceName(rs.getString("ServiceName"));
				reserva.setFecha(rs.getDate("Fecha"));
				reserva.setHora(rs.getTime("Hora"));
			}
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		return reserva;
	}
	
	
	@Override
	public ArrayList<Reserva> getReservas() {
		
		ArrayList<Reserva> listReserv = new ArrayList<Reserva>();
		
		try {
			conn = ConnectionProvider.getConnection();
			System.out.println("success"+conn);
			ps= conn.prepareStatement("select * from Reserva");
			
			ResultSet rs= ps.executeQuery();
			
			Reserva reserva = new Reserva();
			
			while(rs.next()) {
					
				reserva.setIdReserva(rs.getInt("IdReserva"));
				reserva.setServiceName(rs.getString("ServiceName"));
				reserva.setFecha(rs.getDate("Fecha"));
				reserva.setHora(rs.getTime("Hora"));
				listReserv.add(reserva);
			}
					
			conn.close();
			
		}catch(Exception e){
			
			System.out.println(e);
			e.printStackTrace();
		}
			
		return listReserv;
	}

}

