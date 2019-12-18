package com.mvcg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mvcg.entidades.Factura;;

public class FacturaDao {
	
	// lista de factura
	private List facturaLista = new ArrayList<Factura>();
	// Gestionar la respuesta si la transacción fue satisfactoria o no
	private String respuesta = "";
	// objeto dao
	private DaoManager daoManager;
	
	public List selectFactura() {
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			facturaLista = em.createNamedQuery("Factura.findAll").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			em.close();
		}
		return facturaLista;
	}// end selectFactura
	
	public String insertFactura(Factura factura) {
		
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			em.getTransaction().begin();
			em.persist(factura);
			em.getTransaction().commit();
			respuesta = "Factura guardada";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuesta = "error guardando factua";
		}
		return respuesta;
		
	}// end insertFactura
	
	
	// Parecido al insert, pero se hace un merge
	public String updateFactura(Factura factura) {
		
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			em.getTransaction().begin();
			em.merge(factura);
			em.getTransaction().commit();
			respuesta = "Factura modificada";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuesta = "error al modificar factura factua";
		}
		return respuesta;
		
	}// end updateFactura
	
	
	// Parece lo mismo, pero primero se hace un merge luego un remove
	public String deleteFactura(Factura factura) {
		
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			em.getTransaction().begin();
			Factura facturaRemove = em.merge(factura);
			em.remove(facturaRemove);			
			em.getTransaction().commit();
			respuesta = "Factura eliminada";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuesta = "error al eliminar factura factua";
		}
		return respuesta;
		
	}// end deleteFactura
	
	
	
	

}// endClass
