package com.gtigsmart.mis;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.gtigsmart.mis.truck.TruckChargeItem;
import com.gtigsmart.mis.truck.TruckInvoice;


public class o2mHibernate {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StandardServiceRegistry  serviceRegistry=new StandardServiceRegistryBuilder().configure().build(); 
        SessionFactory sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        Session session=sessionFactory.getCurrentSession();
        Transaction tx =session.beginTransaction();
        
        TruckInvoice inv001 = new TruckInvoice();
		inv001.setInvoiceNo("001");
		TruckChargeItem item01 = new TruckChargeItem();
		item01.setChargeItem("item_01");
		item01.setChargeAmount(22.22);
		item01.setTruckInvoice(inv001);
		inv001.getChargeItems().add(item01);
        
		session.save(inv001);
		tx.commit();
		StandardServiceRegistryBuilder.destroy(serviceRegistry);
		
		fail("Not yet implemented");
	}

}
