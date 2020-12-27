package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Reservation;

import java.util.List;

@Repository
public interface ReservationRepository  extends CrudRepository<Reservation, Long> {

    public List<Reservation> findAllByBookingPerson(BookingPerson bookingPerson);

}
