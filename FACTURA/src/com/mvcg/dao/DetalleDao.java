package com.mvcg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mvcg.entidades.Detalle;

public class DetalleDao {
	private List detalleLista = new ArrayList<Detalle>();
	private DaoManager daoManager;
	private String respuesta = "";
	
	public List selectDetalle(long idFactura) {
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			// se agrega una nueva namedQuery
			detalleLista = em.createNamedQuery("Detalle.findByFacturaId").setParameter("idFactura", idFactura).getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return detalleLista;
	}// end
	
	public String insertDetalle(Detalle detalle) {
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			em.getTransaction().begin();
			em.persist(detalle);
			em.getTransaction().commit();
			respuesta = "detalle guardado";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuesta = "error al guardar";
		}
		return respuesta;		
		
	}// end

	
	public String deleteDetalle(Detalle detalle) {
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		
		try {
			em.getTransaction().begin();
			Detalle detalleRemove = em.merge(detalle);
			em.remove(detalleRemove);
			em.getTransaction().commit();
			respuesta = "detalle eliminado";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			respuesta = "error al eliminar detalle";
		}
		return respuesta;		
		
	}// end
	
	public String totalDetalle(long idFactura) {
		
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		String total = "";
		
		try {
			Object obj = em.createNamedQuery("Detalle.total").setParameter("idFactura", idFactura);
			total = (String) obj;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return total;
		
	}
	

}
