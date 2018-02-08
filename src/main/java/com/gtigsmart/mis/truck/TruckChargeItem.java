package com.gtigsmart.mis.truck;



import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "truck_charge_item", catalog = "gtigsmart")
public class TruckChargeItem implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String chargeItem;
	private String chargeDesc;
	private double chargeAmount;
	private TruckInvoice truckInvoice;
	
	/**
	 * @param id
	 * @param chargeItem
	 * @param chargeDesc
	 * @param chargeAmount
	 * @param truckInvoice
	 */
	public TruckChargeItem(Integer id, String chargeItem, String chargeDesc, double chargeAmount,
			TruckInvoice truckInvoice) {
		super();
		this.id = id;
		this.chargeItem = chargeItem;
		this.chargeDesc = chargeDesc;
		this.chargeAmount = chargeAmount;
		this.truckInvoice = truckInvoice;
	}
	
	public TruckChargeItem() {
	
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "charge_item")
	public String getChargeItem() {
		return chargeItem;
	}
	
	public void setChargeItem(String chargeItem) {
		this.chargeItem = chargeItem;
	}
	
	@Column(name = "charge_desc")
	public String getChargeDesc() {
		return chargeDesc;
	}
	
	public void setChargeDesc(String chargeDesc) {
		this.chargeDesc = chargeDesc;
	}
	
	@Column(name = "charge_amount")
	public double getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inv_no", nullable = false)
	public TruckInvoice getTruckInvoice() {
		return truckInvoice;
	}
	public void setTruckInvoice(TruckInvoice truckInvoice) {
		this.truckInvoice = truckInvoice;
	}

}
