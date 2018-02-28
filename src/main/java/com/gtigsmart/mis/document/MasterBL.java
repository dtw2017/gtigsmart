package com.gtigsmart.mis.document;

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

public class MasterBL {
	private String mblNo;
	private Date eta;
	private Date etd;
	
	public String getMblNo() {
		return mblNo;
	}
	public void setMblNo(String mblNo) {
		this.mblNo = mblNo;
	}
	public Date getEta() {
		return eta;
	}
	public void setEta(Date eta) {
		this.eta = eta;
	}
	public Date getEtd() {
		return etd;
	}
	public void setEtd(Date etd) {
		this.etd = etd;
	}
	

}
