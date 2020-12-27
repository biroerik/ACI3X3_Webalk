package com.meiit.webalk.aci3x3;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private BigDecimal amount;
	private LocalDateTime fromTime;
	private LocalDateTime toTime;
	private boolean active;
	private boolean processed;
	@OneToOne
	private BookingPerson bookingPerson;
	@OneToOne
	private Room room;

	public Reservation(){
		super();
	}
	
	public Reservation(BigDecimal amount,
			LocalDateTime fromTime,
			LocalDateTime toTime,
			boolean active,
			boolean processed,
			BookingPerson bookingPerson,
			Room room) {
		super();
		this.amount = amount;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.active = active;
		this.processed = processed;
		this.bookingPerson = bookingPerson;
		this.room = room;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public BookingPerson getBookingPerson() {
		return bookingPerson;
	}
	public void setBookingPerson(BookingPerson bookingPerson) {
		this.bookingPerson = bookingPerson;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public LocalDateTime getFrom() {
		return fromTime;
	}
	public void setFrom(LocalDateTime from) {
		this.fromTime = from;
	}
	public LocalDateTime getTo() {
		return toTime;
	}
	public void setTo(LocalDateTime to) {
		this.toTime = to;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isProcessed() {
		return processed;
	}
	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
