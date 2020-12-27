package com.meiit.webalk.aci3x3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Floor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Integer floorNumber;
	@ManyToOne
	private Hotel hotel;
	@OneToMany
	private List<Wing> wings;

	public Floor(){
		super();
	}

	public Floor(Integer floorNumber, Hotel hotel) {
		super();
		this.floorNumber = floorNumber;
		this.hotel = hotel;
		this.wings = new ArrayList<>();
	}
	
	public void addWing(Wing wing) {
		this.wings.add(wing);
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Wing> getWings() {
		return wings;
	}

	public void setWings(ArrayList<Wing> wings) {
		this.wings = wings;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
