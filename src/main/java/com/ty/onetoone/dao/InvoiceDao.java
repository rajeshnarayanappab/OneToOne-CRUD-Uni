package com.ty.onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetone.dto.Invoice;
import com.ty.onetone.dto.Item;

public class InvoiceDao {
	private EntityManagerFactory entityManagerFactory=null;
	private EntityTransaction entityTransaction=null;
	private EntityManager getEntityManger() {
		entityManagerFactory =Persistence.createEntityManagerFactory(null);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void save(Invoice invoice,Item item) {
		entityManagerFactory =Persistence.createEntityManagerFactory(null);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(invoice);
		entityManager.persist(item);
		entityTransaction.commit();

	}
	public Invoice getInvoice(int id) {
		EntityManager entityManager = getEntityManger();
		return entityManager.find(Invoice.class,id);
	}

	public void deleteInvoiceAndItem(int id) {
		EntityManager entityManager = getEntityManger();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Invoice invoice = entityManager.find(Invoice.class, id);
		if(invoice!=null) {
			Item item = invoice.getItem();
			entityManager.remove(invoice);
			
			if(item!=null) {
				entityManager.remove(item);
			}
			entityTransaction.commit();

		}
	}
	public void updateInvoice(Invoice invoice) {
		EntityManager entityManager = getEntityManger();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(invoice);
		
	}
}
