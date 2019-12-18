package com.mvcg.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mvcg.dao.ProductoDao;
import com.mvcg.entidades.Producto;

@ManagedBean
@ViewScoped

public class ProductoService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List listaProductos = new ArrayList<Producto>();
	private ProductoDao productoDao = new ProductoDao();
	
	public void listarProductos() {
		listaProductos = productoDao.ListarProductos();
	}

	public List getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
	

}// endClass
