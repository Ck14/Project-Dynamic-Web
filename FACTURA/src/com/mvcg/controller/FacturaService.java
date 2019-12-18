package com.mvcg.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mvcg.dao.FacturaDao;
import com.mvcg.dao.ProductoDao;
import com.mvcg.entidades.Factura;
import com.mvcg.util.ManageUtil;

@ManagedBean
//@ManagedBean (name= "facturaService", eager=true)
@SessionScoped

public class FacturaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Factura facturaForm = new Factura();
	private List listaFactura = new ArrayList<Factura>();// lista para llenar el dataTable
	private List listaFacturaFiltered = new ArrayList<Factura>();// lista para filtrarla
	private FacturaDao facturaDao = new FacturaDao();
	private String respuesta = "";
	private boolean mostrarBotonGuardar = true;
	private boolean mostrarBotonActualizar = false;
	private boolean mostrarBotonVolver = false;
	private ManageUtil mu = new ManageUtil();
	
	public void listarFacturas() {
		listaFactura = facturaDao.selectFactura();
		listaFacturaFiltered = facturaDao.selectFactura();
	}
	
	public void crearFactura() {
		Date date = new Date();
		facturaForm.setFechaActualizacion(new Timestamp(date.getTime()));
		respuesta = facturaDao.insertFactura(facturaForm);
		mu.agregarMensaje(respuesta);
		limpiarFormulario();
	}
	
	public void actualizarFactura() {
		Date date = new Date();
		facturaForm.setFechaActualizacion(new Timestamp(date.getTime()));
		respuesta = facturaDao.updateFactura(facturaForm);
		mu.agregarMensaje(respuesta);
		limpiarFormulario();
	}
	
	public void eliminarFactura(Factura factura) {
		respuesta = facturaDao.deleteFactura(factura);
		mu.agregarMensaje(respuesta);
		limpiarFormulario();
	}
	
	public void limpiarFormulario() {
		facturaForm = new Factura();
		mostrarBotonGuardar = true;
		mostrarBotonActualizar = false;
		mostrarBotonVolver = false;
		
	}
	
	public void llenarFormulario(Factura factura) {
		facturaForm.setIdFactura(factura.getIdFactura());
		facturaForm.setCliente(factura.getCliente());
		facturaForm.setCui(factura.getCui());
		facturaForm.setFechaFactura(factura.getFechaFactura());
		facturaForm.setFechaActualizacion(factura.getFechaActualizacion());
		mostrarBotonGuardar = false;
		mostrarBotonActualizar = true;
		mostrarBotonVolver = true;
				
	}
	
	
	public String irADetalle(Factura factura) {
		facturaForm.setIdFactura(factura.getIdFactura());
		facturaForm.setCliente(factura.getCliente());		
		return "Detalle";		
	}
	
	
	
	
	
	
	public Factura getFacturaForm() {
		return facturaForm;
	}
	public void setFacturaForm(Factura facturaForm) {
		this.facturaForm = facturaForm;
	}
	public List getListaFactura() {
		return listaFactura;
	}
	public void setListaFactura(List listaFactura) {
		this.listaFactura = listaFactura;
	}
	public List getListaFacturaFiltered() {
		return listaFacturaFiltered;
	}
	public void setListaFacturaFiltered(List listaFacturaFiltered) {
		this.listaFacturaFiltered = listaFacturaFiltered;
	}
	public boolean isMostrarBotonGuardar() {
		return mostrarBotonGuardar;
	}
	public void setMostrarBotonGuardar(boolean mostrarBotonGuardar) {
		this.mostrarBotonGuardar = mostrarBotonGuardar;
	}
	public boolean isMostrarBotonActualizar() {
		return mostrarBotonActualizar;
	}
	public void setMostrarBotonActualizar(boolean mostrarBotonActualizar) {
		this.mostrarBotonActualizar = mostrarBotonActualizar;
	}
	public boolean isMostrarBotonVolver() {
		return mostrarBotonVolver;
	}
	public void setMostrarBotonVolver(boolean mostrarBotonVolver) {
		this.mostrarBotonVolver = mostrarBotonVolver;
	}
	
	
	
	
	

}
