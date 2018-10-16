package com.fchcc.carwashadmin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@NamedQuery(name="Reserva.findAll", query="select r from Reserva r")
public class Reserva implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	@NotEmpty
	private String serviceName;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fecha;
	
	@DateTimeFormat(pattern="hh:mm:ss")
	private Date hora;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
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
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
}
