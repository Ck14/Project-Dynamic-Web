package com.mvcg.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.mvcg.entidades.Producto;

public class ProductoDao {
	// Lista para guardar junto con el detalle de la factura
	private static List productoLista = new ArrayList<Producto>();
	// referencia a la clase DaoManager
	private static DaoManager daoManager;
	
	// devuelve la lista de productos
	public List ListarProductos() {
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		try {
			// obtenermos lista
			productoLista = em.createNamedQuery("Producto.findAll").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return productoLista;
	}// end
	
	// Check to work
	public static void main(String[] args) {
		daoManager = new DaoManager();
		EntityManager em = daoManager.getEm();
		try {
			productoLista = em.createNamedQuery("Producto.findAll").getResultList();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(productoLista.size());
	}

}// endClass
