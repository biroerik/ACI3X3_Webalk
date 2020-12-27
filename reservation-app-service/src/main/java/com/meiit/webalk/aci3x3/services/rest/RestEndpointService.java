package com.meiit.webalk.aci3x3.services.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Hotel;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.Room;
import com.meiit.webalk.aci3x3.Wing;
import com.meiit.webalk.aci3x3.repositories.BookingPersonRepository;
import com.meiit.webalk.aci3x3.repositories.HotelRepository;
import com.meiit.webalk.aci3x3.repositories.ReservationRepository;
import com.meiit.webalk.aci3x3.repositories.RoomRepository;
import com.meiit.webalk.aci3x3.repositories.WingRepository;

@Service
public class RestEndpointService implements IRestEndpointService {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    WingRepository wingRepository;
    @Autowired
    BookingPersonRepository bookingPersonRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public void addHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Wing getWingById(Long id) {
        return wingRepository.getById(id);
    }

    @Override
    public void addBookingPerson(BookingPerson bookingPerson) {
        bookingPersonRepository.save(bookingPerson);
    }

    @Override
    public BookingPerson getBookingPersonById(Long id){
        Optional<BookingPerson> optionalBookingPerson = bookingPersonRepository.findById(id);
        if(optionalBookingPerson == null){
            return null;
        }
        BookingPerson bookingPerson = optionalBookingPerson.get();
        return bookingPerson;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }
}
