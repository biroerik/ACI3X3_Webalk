package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Hotel;

@Repository
public interface HotelRepository  extends CrudRepository<Hotel, Long> {
}
