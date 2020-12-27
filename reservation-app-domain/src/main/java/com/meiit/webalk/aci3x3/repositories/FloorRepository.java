package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Floor;
import com.meiit.webalk.aci3x3.Hotel;

import java.util.List;

@Repository
public interface FloorRepository  extends CrudRepository<Floor, Long> {

    public List<Floor> findAllByHotel(Hotel hotel);
}
