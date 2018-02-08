package com.gtigsmart.mis.truck;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "truck_cargo_item")

public class TruckCargoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "inv_no")
	private String invID;

	@Column(name = "pkg_no")
	private Integer pkgNo;

	@Column(name = "cargo_wgt")
	private double cargoWeight;

	@Column(name = "cargo_desc")
	private String cargoDesc;

	@Column(name = "cargo_remarks")
	private String cargoRemarks;

	@ManyToOne
	@JoinColumn(name = "truck_cargo_inv_no")
	private TruckInvoice truckInvoice;
}
