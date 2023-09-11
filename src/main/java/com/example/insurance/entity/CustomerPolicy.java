package com.example.insurance.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CustomerPolicy")
public class CustomerPolicy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cpid;
	
    @ManyToOne
    @JoinColumn(name="custId",referencedColumnName = "custId")
	private Customer customer;
    
    @OneToOne
    @JoinColumn(name="pid",referencedColumnName = "pid")
    private Policy policy;
    
    @OneToOne
    @JoinColumn(name="accid",referencedColumnName = "accid")
    private Account account;
    
    @Column(name="regDate")
    private Date regDate;

    @Column(name="paymentDate")
    private Date paymentDate;
    
    //@Column(name="dateOfLastPayment")
    //private Date dateOfLastPayment;
    
    //@Column(name="dateOfMaturity")
    //private Date dateOfMaturity;

    @Column(name="amount")
    private int amount;
    
    @Column(name="term")
    private int term;
    
    @Column(name="sumAssured")
    private float sumAssured;
    
    @Column(name="paymentMode")
    private String paymentMode;
    
   
    //@Column(name="ageOfAdmission")
    //private int ageOfAdmission;
    
    @Column(name="nextDueDate")
    private Date nextDueDate;

	public int getCpid() {
		return cpid;
	}

	public void setCpid(int cpid) {
		this.cpid = cpid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/*public Date getDateOfLastPayment() {
		return dateOfLastPayment;
	}

	public void setDateOfLastPayment(Date dateOfLastPayment) {
		this.dateOfLastPayment = dateOfLastPayment;
	}

	public Date getDateOfMaturity() {
		return dateOfMaturity;
	}

	public void setDateOfMaturity(Date dateOfMaturity) {
		this.dateOfMaturity = dateOfMaturity;
	}
*/
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public float getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(float sumAssured) {
		this.sumAssured = sumAssured;
	}
	
	

    public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	/*	public int getAgeOfAdmission() {
		return ageOfAdmission;
	}

	public void setAgeOfAdmission(int ageOfAdmission) {
		this.ageOfAdmission = ageOfAdmission;
	}
*/
	public Date getNextDueDate() {
		return nextDueDate;
	}

	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate = nextDueDate;
	}
    
    
}
