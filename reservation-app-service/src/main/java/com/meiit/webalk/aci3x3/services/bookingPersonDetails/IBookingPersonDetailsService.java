package com.meiit.webalk.aci3x3.services.bookingPersonDetails;

import java.util.List;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Reservation;

public interface IBookingPersonDetailsService {

    public BookingPerson findByEmail(String email);
    public List<Reservation> findReservationsOf(String email);
    public void saveBookingPerson(BookingPerson bookingPerson);
}
