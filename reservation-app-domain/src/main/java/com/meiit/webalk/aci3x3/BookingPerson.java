package com.meiit.webalk.aci3x3;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class BookingPerson extends User{

	private String name;
	private Integer accountNumber;
	private BigDecimal balance;
	private LocalDate birth;
	@Column
	private Currency currency;

	public BookingPerson(){
		super();
	}

	public BookingPerson(String email,
			String password,
			String name,
			Integer accountNumber,
			BigDecimal balance,
			LocalDate birth,
			Currency currency) {
		super(email, password);
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.birth = birth;
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
}
