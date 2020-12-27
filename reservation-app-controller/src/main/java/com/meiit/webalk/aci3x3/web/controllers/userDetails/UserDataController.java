package com.meiit.webalk.aci3x3.web.controllers.userDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Reservation;
import com.meiit.webalk.aci3x3.repositories.ReservationRepository;
import com.meiit.webalk.aci3x3.services.bookingPersonDetails.BookingPersonDetailsService;

import java.util.List;

@Controller
public class UserDataController {

    @Autowired
    BookingPersonDetailsService bookingPersonDetailsService;

    @GetMapping("/userDetails")
    public String getUserDetails(Model model){
        String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        BookingPerson bookingPerson = bookingPersonDetailsService.findByEmail(username);
        
        model.addAttribute("bookingPerson", bookingPerson);
        List<Reservation> reservations = bookingPersonDetailsService.findReservationsOf(username);
        
        model.addAttribute("reservations", reservations);
        
        return "userData";
    }
    
    
    

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("bookingPerson") BookingPerson bookingPerson){
    	
        bookingPersonDetailsService.saveBookingPerson(bookingPerson);
        
        return "redirect:/userDetails";
    }
}
