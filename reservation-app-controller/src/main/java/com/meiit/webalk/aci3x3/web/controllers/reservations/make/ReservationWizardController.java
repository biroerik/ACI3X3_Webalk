package com.meiit.webalk.aci3x3.web.controllers.reservations.make;

import com.meiit.webalk.aci3x3.*;
import com.meiit.webalk.aci3x3.services.bookingPersonDetails.BookingPersonDetailsService;
import com.meiit.webalk.aci3x3.services.exceptions.NotEnoughBalanceException;
import com.meiit.webalk.aci3x3.services.reservation.make.ReservationCreatorService;
import com.meiit.webalk.aci3x3.web.dtos.DTORoom;
import com.meiit.webalk.aci3x3.web.dtos.DTORoomTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationWizardController {

    private Hotel chosenHotel;
    private Floor chosenFloor;
    private Wing chosenWing;
    private NotEnoughBalanceException exception;
    @Autowired
    ReservationCreatorService reservationCreatorService;
    @Autowired
    BookingPersonDetailsService bookingPersonDetailsService;

    @GetMapping("/newReservationWizard/showHotels")
    public String showHotelList(Model model){
        clearChoices();
        List<Hotel> hotels = reservationCreatorService.getAllHotels();
        model.addAttribute("hotels", hotels);
        return "chooseHotel";
    }

    @PostMapping("/newReservationWizard/chooseHotel")
    public String chooseHotel(@ModelAttribute("hotel") Hotel hotel){
        this.chosenHotel = hotel;
        return "redirect:/newReservationWizard/showFloors";
    }

    @GetMapping("/newReservationWizard/showFloors")
    public String showFloorList(Model model){
        List<Floor> floors = reservationCreatorService.getFloorsOfHotel(this.chosenHotel);
        model.addAttribute("hotel", this.chosenHotel);
        model.addAttribute("floors", floors);
        return "chooseFloor";
    }

    @PostMapping("/newReservationWizard/chooseFloor")
    public String chooseFloor(@ModelAttribute("floor") Floor floor){
        this.chosenFloor = floor;
        return "redirect:/newReservationWizard/showWings";
    }

    @GetMapping("/newReservationWizard/showWings")
    public String showWings(Model model){
        List<Wing> wings = reservationCreatorService.getWingsOfFloor(this.chosenFloor);
        model.addAttribute("hotel", this.chosenHotel);
        model.addAttribute("floor", this.chosenFloor);
        model.addAttribute("wings", wings);
        return "chooseWing";
    }

    @PostMapping("/newReservationWizard/chooseWing")
    public String chooseWing(@ModelAttribute("wing") Wing wing){
        this.chosenWing = wing;
        return "redirect:/newReservationWizard/showRooms";
    }

    @GetMapping("newReservationWizard/showRooms")
    public String showRooms(Model model){
        List<Room> rooms = reservationCreatorService.getRoomsOfWing(this.chosenWing);
        List<DTORoom> dtoRooms = new ArrayList<>();
        for(int i = 0; i < rooms.size(); i++){
            dtoRooms.add(DTORoomTransformer.transformRoomToDTORoom(rooms.get(i)));
        }
        model.addAttribute("room", new DTORoom());
        model.addAttribute("rooms", dtoRooms);
        model.addAttribute("hotel", this.chosenHotel);
        model.addAttribute("floor", this.chosenFloor);
        model.addAttribute("wing",this.chosenWing);
        return "chooseRoom";
    }

    @PostMapping("/newReservationWizard/chooseRoom")
    public String chooseRoom(@ModelAttribute("room") DTORoom dtoRoom){
        Room room = DTORoomTransformer.transformDTORoomToRoom(dtoRoom);
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        BookingPerson bookingPerson = bookingPersonDetailsService.findByEmail(username);
        Reservation reservation = new Reservation(
                new BigDecimal(1),
                LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(3),
                false,
                false,
                bookingPerson,
                room);
        try {
            reservationCreatorService.addReservation(reservation);
        }
        catch (NotEnoughBalanceException exc){
            this.exception = exc;
            return "redirect:/newReservationWizard/failure";
        }
        return "redirect:/newReservationWizard/success";
    }

    @GetMapping("/newReservationWizard/success")
    public String showSuccess(){
        return "successfulReservation";
    }

    @GetMapping("/newReservationWizard/failure")
    public String showError(Model model){
        model.addAttribute("exception",this.exception);
        return "reservationFailure";
    }

    private void clearChoices(){
        this.chosenHotel = null;
        this.chosenFloor = null;
        this.chosenWing = null;
    }
}
