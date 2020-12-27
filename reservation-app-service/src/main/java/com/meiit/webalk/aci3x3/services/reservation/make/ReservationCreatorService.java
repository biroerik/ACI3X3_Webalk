package com.meiit.webalk.aci3x3.services.reservation.make;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Floor;
import com.meiit.webalk.aci3x3.Hotel;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.Room;
import com.meiit.webalk.aci3x3.Wing;
import com.meiit.webalk.aci3x3.repositories.BookingPersonRepository;
import com.meiit.webalk.aci3x3.repositories.FloorRepository;
import com.meiit.webalk.aci3x3.repositories.HotelRepository;
import com.meiit.webalk.aci3x3.repositories.ReservationRepository;
import com.meiit.webalk.aci3x3.repositories.RoomRepository;
import com.meiit.webalk.aci3x3.repositories.WingRepository;
import com.meiit.webalk.aci3x3.services.bookingPersonDetails.BookingPersonDetailsService;
import com.meiit.webalk.aci3x3.services.exceptions.NotEnoughBalanceException;

@Service
public class ReservationCreatorService implements IReservationCreatorService{

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    FloorRepository floorRepository;
    @Autowired
    WingRepository wingRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingPersonRepository bookingPersonRepository;
    @Autowired
    BookingPersonDetailsService bookingPersonDetailsService;

    @Override
    public List<Hotel> getAllHotels() {
        return (List<Hotel>) hotelRepository.findAll();
    }

    @Override
    public List<Floor> getFloorsOfHotel(Hotel hotel) {
        return floorRepository.findAllByHotel(hotel);
    }

    @Override
    public List<Wing> getWingsOfFloor(Floor floor) {
        return wingRepository.findAllByFloor(floor);
    }

    @Override
    public List<Room> getRoomsOfWing(Wing wing) {
        return roomRepository.findAllByWing(wing);
    }

    @Override
    public void addReservation(Reservation reservation) throws NotEnoughBalanceException{
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        
        BookingPerson bookingPerson = bookingPersonDetailsService.findByEmail(username);
        
        BigDecimal balance = bookingPerson.getBalance();
        
        
        Room room = roomRepository.findById(reservation.getRoom().getId()).get();
        
        BigDecimal required = room.getPrice();
        BigDecimal newBalance = balance.subtract(required);
        
        if(newBalance.compareTo(BigDecimal.ZERO) == -1){
            throw new NotEnoughBalanceException(balance, required);
        }
        else{
            bookingPerson.setBalance(newBalance);
        }
        bookingPersonRepository.save(bookingPerson);
        reservationRepository.save(reservation);
    }
}
