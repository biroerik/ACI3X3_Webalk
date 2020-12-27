package com.meiit.webalk.aci3x3.services.bookingPersonDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.repositories.BookingPersonRepository;
import com.meiit.webalk.aci3x3.repositories.ReservationRepository;

@Service
public class BookingPersonDetailsService implements IBookingPersonDetailsService{

    @Autowired
    BookingPersonRepository bookingPersonRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public BookingPerson findByEmail(String email) {
        BookingPerson bookingPerson = bookingPersonRepository.findByEmail(email);
        if(bookingPerson == null){
            throw new UsernameNotFoundException(email);
        }
        return bookingPerson;
    }

    @Override
    public List<Reservation> findReservationsOf(String email) {
        BookingPerson bookingPerson = bookingPersonRepository.findByEmail(email);
        if(bookingPerson == null){
            throw new UsernameNotFoundException(email);
        }
        List<Reservation> reservations = reservationRepository.findAllByBookingPerson(bookingPerson);
        if(reservations == null){
            return null;
        }
        if(reservations.size() == 0){
            return null;
        }
        return reservations;
    }

    @Override
    public void saveBookingPerson(BookingPerson bookingPerson) {
        bookingPersonRepository.save(bookingPerson);
    }
}
