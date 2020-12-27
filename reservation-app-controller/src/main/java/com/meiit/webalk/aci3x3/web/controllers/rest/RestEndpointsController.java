package com.meiit.webalk.aci3x3.web.controllers.rest;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Hotel;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.Room;
import com.meiit.webalk.aci3x3.services.rest.RestEndpointService;
import com.meiit.webalk.aci3x3.web.dtos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestEndpointsController {

    @Autowired
    RestEndpointService restEndpointService;

    @PostMapping("/add-hotel")
    public void addHotel(DTOHotel dtoHotel){
        Hotel hotel = DTOHotelTransformer.transformDTOHotelToHotel(dtoHotel);
        restEndpointService.addHotel(hotel);
    }

    @PostMapping("/add-room")
    public void addRoom(DTORoomRest dtoRoomRest){
        Room room = DTORoomTransformer.transformDTORoomRestToRoom(dtoRoomRest, restEndpointService);
        System.out.println(room.getBeds());
        System.out.println(room.getWing());
        System.out.println(room.getCurrency());
        System.out.println(room.getNumber());
        System.out.println(room.getPrice());
        restEndpointService.addRoom(room);
    }

    @PostMapping("/create-user")
    public void createUser(DTOBookingPersonRest dtoBookingPersonRest){
        BookingPerson bookingPerson = DTOBookingPersonTransformer.transformDTOBookingPersonRestToBookingPerson(dtoBookingPersonRest);
        restEndpointService.addBookingPerson(bookingPerson);
    }

    @GetMapping("/user-info")
    public ResponseEntity<BookingPerson> getUserById(Long id){
        BookingPerson bookingPerson = restEndpointService.getBookingPersonById(id);
        
        if(bookingPerson == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(bookingPerson);
        }
    }

    @GetMapping("/show-reservations")
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = restEndpointService.getAllReservations();
        
        if(reservations == null){
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(reservations);
        }
    }
}
