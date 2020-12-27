package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.Floor;
import com.meiit.webalk.aci3x3.Wing;

import java.util.List;

@Repository
public interface WingRepository extends CrudRepository<Wing, Long> {

    public List<Wing> findAllByFloor(Floor floor);
    public Wing getById(Long id);
}
