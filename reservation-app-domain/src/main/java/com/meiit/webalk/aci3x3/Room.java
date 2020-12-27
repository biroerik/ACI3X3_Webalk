package com.meiit.webalk.aci3x3;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Integer number;
	private Integer beds;
	private boolean balcon;
	@ManyToOne
	private Wing wing;
	private BigDecimal price;
	private Currency currency;

	public Room(){
		super();
	}

	public Room(Long id, Integer number, Integer beds, boolean balcon, Wing wing, BigDecimal price, Currency currency) {
		super();
		this.id = id;
		this.number = number;
		this.beds = beds;
		this.balcon = balcon;
		this.wing = wing;
		this.price = price;
		this.currency = currency;
	}
	public Room(Integer number, Integer beds, boolean balcon, Wing wing, BigDecimal price, Currency currency) {
		this.number = number;
		this.beds = beds;
		this.balcon = balcon;
		this.wing = wing;
		this.price = price;
		this.currency = currency;
	}
	
	public Wing getWing() {
		return wing;
	}

	public void setWing(Wing wing) {
		this.wing = wing;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getBeds() {
		return beds;
	}
	public void setBeds(Integer beds) {
		this.beds = beds;
	}
	public boolean isBalcon() {
		return balcon;
	}
	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}
