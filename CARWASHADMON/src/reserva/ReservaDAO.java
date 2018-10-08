package reserva;

import java.util.ArrayList;

public interface ReservaDAO {

		public void addReserva(Reserva r);
		public void editReserva(Reserva r);
		public void deleteReserva(Reserva r);
		public ArrayList<Reserva> getReservas();
		public Reserva getReserva(String idReserva);
		
}
