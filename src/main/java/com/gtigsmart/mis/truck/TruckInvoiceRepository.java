package com.gtigsmart.mis.truck;

import org.springframework.data.repository.CrudRepository;

public interface TruckInvoiceRepository extends CrudRepository<TruckInvoice, Integer>{
	TruckInvoice findByinvoiceNo(String invoiceNo);
}
