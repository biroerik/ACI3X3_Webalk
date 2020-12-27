package com.meiit.webalk.aci3x3.web.controllers.login;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.services.registration.RegistrationService;
import com.meiit.webalk.aci3x3.web.dtos.DTOBookingPersonRest;
import com.meiit.webalk.aci3x3.web.dtos.DTOBookingPersonTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/accessdenied")
    public String deniedLogin(){
        return "loginDenied";
    }

    @RequestMapping("/registerPage")
    public String registerShow(Model model){

        model.addAttribute("dtoBookingPerson", new DTOBookingPersonRest());
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("bookingPerson") DTOBookingPersonRest dtoBookingPerson){
        BookingPerson bookingPerson = DTOBookingPersonTransformer
                .transformDTOBookingPersonRestToBookingPerson(dtoBookingPerson);
        registrationService.registerBookingPerson(bookingPerson);
        return "login";
    }
}
