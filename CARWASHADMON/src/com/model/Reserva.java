package reserva;

import java.sql.Date;
import java.sql.Time;

public class Reserva {
		
		public int idReserva;
		private String serviceName;
		private Date fecha;
		private Time hora;
		
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		public Time getHora() {
			return hora;
		}
		public void setHora(Time hora) {
			this.hora = hora;
		}
		public int getIdReserva() {
			return idReserva;
		}
		public void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}
		
		
}
