package com.ty.onetoone.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetone.dto.Invoice;
import com.ty.onetone.dto.Item;
import com.ty.onetoone.dao.InvoiceDao;

public class TestController {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(null);
		EntityManager  entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		InvoiceDao dao = new InvoiceDao();

		Item item = new Item();
		item.setId(1);
		item.setName("Book");
		item.setPrice(200.0);
		item.setQty(1);

		Invoice invoice = new Invoice();
		invoice.setId(1);
		invoice.setName("book invoice");
		invoice.setBillingAddress("Blr BTM");
		invoice.setGstNumber("ARER12");
		invoice.setTax(12.54);
		
		invoice.setItem(item);
		dao.save(invoice,item);
		


	}

}
