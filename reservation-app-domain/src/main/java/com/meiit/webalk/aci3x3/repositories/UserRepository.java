package com.meiit.webalk.aci3x3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.meiit.webalk.aci3x3.BookingPerson;
import com.meiit.webalk.aci3x3.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
