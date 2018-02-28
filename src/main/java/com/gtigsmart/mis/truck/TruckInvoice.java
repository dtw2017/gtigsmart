package com.gtigsmart.mis.truck;

/** 
 * @author Thomas JIAO
 *
 */
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "truck_invoice", catalog = "gtigsmart")

public class TruckInvoice implements java.io.Serializable{

	
	private static final long serialVersionUID = 1L;

	private String invoiceNo;
	private Date invoiceDate;
	private Date dueDate;
	private String referenceNo;
	private Date shipDate;
	private Date arrivalDate;
	private String opReferenceNo;
	private String shipTo;
	private Boolean approval;
	private Set<TruckChargeItem> chargeItems = new HashSet<TruckChargeItem>(0);		//Charge item included in the invoice

	/**
	 * @param invoiceNo
	 * @param invoiceDate
	 * @param dueDate
	 * @param referenceNo
	 * @param shipDate
	 * @param arrivalDate
	 * @param opReferenceNo
	 * @param shipTo
	 * @param chargeItems
	 */
	public TruckInvoice(String invoiceNo, Date invoiceDate, Date dueDate, String referenceNo, Date shipDate,
			Date arrivalDate, String opReferenceNo, String shipTo, Set<TruckChargeItem> chargeItems) {
		super();
		this.invoiceNo = invoiceNo;
		this.invoiceDate = invoiceDate;
		this.dueDate = dueDate;
		this.referenceNo = referenceNo;
		this.shipDate = shipDate;
		this.arrivalDate = arrivalDate;
		this.opReferenceNo = opReferenceNo;
		this.shipTo = shipTo;
		this.chargeItems = chargeItems;
	}

	public TruckInvoice() {
		super();
	}
	
	@Id
	@Column(name = "inv_no", unique = true, nullable = false)
	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	@Column(name = "inv_date")
	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	@Column(name = "due_date")
	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "ref_no")
	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	@Column(name = "ship_date")
	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	@Column(name = "arrival_date")
	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	@Column(name = "op_refer_no")
	public String getOpReferenceNo() {
		return opReferenceNo;
	}

	public void setOpReferenceNo(String opReferenceNo) {
		this.opReferenceNo = opReferenceNo;
	}

	@Column(name = "ship_to")
	public String getShipTo() {
		return shipTo;
	}

	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "truckInvoice")
	//@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "truckInvoice")
	//@OrderBy("id asc")		//ascending order by ID
	public Set<TruckChargeItem> getChargeItems() {
		return chargeItems;
	}

	public void setChargeItems(Set<TruckChargeItem> chargeItems) {
		this.chargeItems = chargeItems;
	}

	public Boolean getApproval() {
		return approval;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
	}

}
