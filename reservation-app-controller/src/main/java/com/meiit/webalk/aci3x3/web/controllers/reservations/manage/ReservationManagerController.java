package com.meiit.webalk.aci3x3.web.controllers.reservations.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.services.reservation.manage.ReservationManagerService;

@Controller
public class ReservationManagerController {

    @Autowired
    ReservationManagerService reservationManagerService;

    @RequestMapping("/deleteReservation")
    public String deleteReservation(@ModelAttribute("reservation") Reservation reservation){
        reservationManagerService.deleteReservation(reservation);
        
        return "redirect:/userDetails";
    }
}
