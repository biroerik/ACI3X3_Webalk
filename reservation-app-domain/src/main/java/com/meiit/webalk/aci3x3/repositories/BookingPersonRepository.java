package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;

@Repository
public interface BookingPersonRepository extends CrudRepository<BookingPerson, Long> {

    public BookingPerson findByEmail(String email);
}
