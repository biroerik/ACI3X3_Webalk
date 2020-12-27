package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Room;
import com.meiit.webalk.aci3x3.Wing;

import java.util.List;

@Repository
public interface RoomRepository  extends CrudRepository<Room, Long> {

    public List<Room> findAllByWing(Wing wing);

}
