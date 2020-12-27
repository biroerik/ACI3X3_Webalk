package com.meiit.webalk.aci3x3.services.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.repositories.BookingPersonRepository;

@Service
public class RegistrationService implements IRegistrationService{

    @Autowired
    private BookingPersonRepository bookingPersonRepository;

    @Override
    public void registerBookingPerson(BookingPerson bookingPerson) {
        bookingPersonRepository.save(bookingPerson);
    }
}
