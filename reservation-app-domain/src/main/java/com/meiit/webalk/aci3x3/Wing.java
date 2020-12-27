package com.meiit.webalk.aci3x3;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Wing {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	@ManyToOne
	private Floor floor;
	@OneToMany
	private List<Room> rooms;
	@Column
	private WingType wingType;

	public Wing(){
		super();
	}

	public Wing(String description, Floor floor, WingType wingType) {
		super();
		this.description = description;
		this.floor = floor;
		this.rooms = new ArrayList<>();
		this.wingType = wingType;
	}

	public void addRoom(Room room) {
		this.rooms.add(room);
	}
	
	public WingType getWingType() {
		return wingType;
	}

	public void setWingType(WingType wingType) {
		this.wingType = wingType;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
