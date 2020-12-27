package com.meiit.webalk.aci3x3.services.rest;

import java.util.List;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Hotel;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.Room;
import com.meiit.webalk.aci3x3.Wing;

public interface IRestEndpointService {

    public void addHotel(Hotel hotel);
    public void addRoom(Room room);
    public Wing getWingById(Long id);
    public void addBookingPerson(BookingPerson bookingPerson);
    public BookingPerson getBookingPersonById(Long id);
    public List<Reservation> getAllReservations();
}
