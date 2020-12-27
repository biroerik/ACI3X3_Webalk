package com.meiit.webalk.aci3x3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String address;
	private Integer stars;
	@OneToMany
	private List<Floor> floors;

	public Hotel(){
		super();
	}

	public Hotel(String name, String address, Integer stars) {
		super();
		this.name = name;
		this.address = address;
		this.stars = stars;
		this.floors = new ArrayList<>();
	}

	public void addFloor(Floor floor) {
		this.floors.add(floor);
	}
	
	public List<Floor> getFloors() {
		return floors;
	}
	public void setFloors(ArrayList<Floor> floors) {
		this.floors = floors;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
