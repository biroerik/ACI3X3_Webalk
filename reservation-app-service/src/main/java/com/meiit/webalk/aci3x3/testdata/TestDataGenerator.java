package com.meiit.webalk.aci3x3.testdata;

import com.meiit.webalk.aci3x3.*;
import com.meiit.webalk.aci3x3.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class TestDataGenerator implements CommandLineRunner {

    @Autowired
    private BookingPersonRepository bookingPersonRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private FloorRepository floorRepository;
    @Autowired
    private WingRepository wingRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public void run(String... args) throws Exception {

        createTestData();
    }

    private void createTestData(){
        BookingPerson bookingPerson = new BookingPerson(
                "john@lock.abc",
                "pass123",
                "John Lock",
                4,
                new BigDecimal(1000),
                LocalDate.of(1632, 8, 29),
                Currency.HUF);
        bookingPersonRepository.save(bookingPerson);

        Hotel hotel = new Hotel("IHotel","Cupertino, CA 95014, Egyesült Államok.",5);
        hotelRepository.save(hotel);

        Floor floor = new Floor(1,hotel);
        floorRepository.save(floor);

        Wing wing = new Wing("Very good.",floor,WingType.EAST);
        wingRepository.save(wing);

        hotel.addFloor(floor);
        floor.addWing(wing);
        Room room1 = new Room(1, 2, false, wing, new BigDecimal(500), Currency.HUF);
        wing.addRoom(room1);
        Room room2 = new Room(2, 4, true, wing, new BigDecimal(1500), Currency.HUF);
        wing.addRoom(room2);
        Room room3 = new Room(3, 3, true, wing, new BigDecimal(1000), Currency.HUF);
        wing.addRoom(room3);
        Room room4 = new Room(4, 2, true, wing, new BigDecimal(500), Currency.HUF);
        wing.addRoom(room4);

        roomRepository.save(room1);
        roomRepository.save(room2);
        roomRepository.save(room3);
        roomRepository.save(room4);

        Reservation reservation = new Reservation(
                new BigDecimal(1),
                LocalDateTime.of(2020,12,15,12,0),
                LocalDateTime.of(2020,12,25,12,0),
                false,
                false,
                bookingPerson,
                room1
        );
        reservationRepository.save(reservation);

    }
}
