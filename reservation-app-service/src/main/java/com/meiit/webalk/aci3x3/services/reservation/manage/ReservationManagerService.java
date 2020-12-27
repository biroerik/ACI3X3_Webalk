package com.meiit.webalk.aci3x3.services.reservation.manage;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.repositories.BookingPersonRepository;
import com.meiit.webalk.aci3x3.repositories.ReservationRepository;
import com.meiit.webalk.aci3x3.services.bookingPersonDetails.BookingPersonDetailsService;

@Service
public class ReservationManagerService implements IReservationManagerService{

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private BookingPersonRepository bookingPersonRepository;

    @Autowired
    private BookingPersonDetailsService bookingPersonDetailsService;

    @Override
    public void deleteReservation(Reservation reservation) {
        if( !reservation.isProcessed()){
            Reservation fetchedReservation = reservationRepository.findById(reservation.getId()).get();
            BigDecimal price = fetchedReservation.getRoom().getPrice();
            String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
            BookingPerson bookingPerson = bookingPersonDetailsService.findByEmail(username);
            bookingPerson.setBalance(bookingPerson.getBalance().add(price));
            bookingPersonRepository.save(bookingPerson);
        }
        reservationRepository.delete(reservation);
    }
}
