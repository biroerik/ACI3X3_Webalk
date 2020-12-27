package com.meiit.webalk.aci3x3.web.dtos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.meiit.webalk.aci3x3.BookingPerson;

public class DTOBookingPersonTransformer {

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static BookingPerson transformDTOBookingPersonRestToBookingPerson(DTOBookingPersonRest dtoBookingPersonRest){
        LocalDate birth = LocalDate.parse(dtoBookingPersonRest.getBirth(), dateTimeFormatter);
                BookingPerson bookingPerson = new BookingPerson(
                dtoBookingPersonRest.getEmail(),
                dtoBookingPersonRest.getPassword(),
                dtoBookingPersonRest.getName(),
                dtoBookingPersonRest.getAccount(),
                dtoBookingPersonRest.getBalance(),
                birth,
                dtoBookingPersonRest.getCurrency()
        );
        return bookingPerson;
    }
}
