package com.meiit.webalk.aci3x3.services.reservation.make;


import com.meiit.webalk.aci3x3.services.exceptions.NotEnoughBalanceException;
import com.meiit.webalk.aci3x3.*;

import java.util.List;

public interface IReservationCreatorService {

    public List<Hotel> getAllHotels();
    public List<Floor> getFloorsOfHotel(Hotel hotel);
    public List<Wing> getWingsOfFloor(Floor floor);
    public List<Room> getRoomsOfWing(Wing wing);
    public void addReservation(Reservation reservation) throws NotEnoughBalanceException;

}
