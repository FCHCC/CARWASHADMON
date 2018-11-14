package com.fchcc.carwashadmin.dao;
import java.util.List;

import com.fchcc.carwashadmin.model.Reserva;

public interface ReservaDAO {
	
	public List<Reserva> getAllReservas();
	public Reserva getStudentById(int id);
	public int save(Reserva r);
	void update(Reserva r);
	void delete(int id);
}
