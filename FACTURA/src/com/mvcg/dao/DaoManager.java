package com.mvcg.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoManager {
	
	private EntityManagerFactory factory;
	private EntityManager em;
	
	public DaoManager() {
		try {
			if(factory == null) {
				// Nombre de JPA Content. xml
				factory = Persistence.createEntityManagerFactory("FACTURA");
			}
			
			if(em == null) {
				em = factory.createEntityManager();
			}
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}// end Constructor
	
	public EntityManager getEm() {
		return em;
	}
	

}// endClass
