package com.example.insurance.entity;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="Policy")
public class Policy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@Column(name="PolicyName")
	private String pname;
	
	@OrderColumn(name="position")
    @ElementCollection
	private Integer[] term;
	
	@OrderColumn(name="position")
	@ElementCollection
	private String[] reqDoc;
	
	@Column(name="rateOfInterest")
	private float rateOfInterest;
	
	@ManyToOne
	@JoinColumn(name="cid",referencedColumnName = "cid")
	private Category category;

	public int getPid() {
		return pid;
	}
      
	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer[] getTerm() {
		return term;
	}

	public void setTerm(Integer[] term) {
		this.term = term;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String[] getReqDoc() {
		return reqDoc;
	}

	public void setReqDoc(String[] reqDoc) {
		this.reqDoc = reqDoc;
	}

	public float getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	

}
