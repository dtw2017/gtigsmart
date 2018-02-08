package com.gtigsmart.mis.truck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TruckInvoiceController {

	private TruckInvoiceRepository truckInvoiceRepository;

	public TruckInvoiceController(TruckInvoiceRepository truckInvoiceRepository) {
		this.truckInvoiceRepository = truckInvoiceRepository;
	}

	@Autowired
	
	@GetMapping(path = "/truckinv")
	public String initTruckInv() {
		return "truckinv";
	}

	@RequestMapping(value = "/truckinv", params = { "save" })
	public @ResponseBody TruckInvoice saveTruckInvoice(@RequestBody TruckInvoice truckinv) {
		System.out.println(truckinv.getChargeItems());
		truckInvoiceRepository.save(truckinv);
	/**
		TruckInvoice inv001 = new TruckInvoice();
		inv001.setInvoiceNo("001");

		TruckChargeItem item0011 = new TruckChargeItem();
		item0011.setChargeItem("item001");
		item0011.setChargeAmount(22.22);
		item0011.setTruckInvoice(inv001);
		inv001.getChargeItems().add(item0011);
		session.save(inv001);
**/
		return truckinv;
	}

	@RequestMapping(value = "/truckinv", params = { "retrieve" })
	public @ResponseBody TruckInvoice retrieveTruckInvoice(@RequestBody String invno) {
		TruckInvoice truckinv = truckInvoiceRepository.findByinvoiceNo(invno);
		System.out.println(truckinv.getInvoiceNo());
		System.out.println(truckinv.getReferenceNo());

		return truckinv;
	}
}
