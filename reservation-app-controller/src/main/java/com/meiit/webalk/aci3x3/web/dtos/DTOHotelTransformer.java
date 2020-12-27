package com.meiit.webalk.aci3x3.web.dtos;

import com.meiit.webalk.aci3x3.Hotel;

public class DTOHotelTransformer {

    public static Hotel transformDTOHotelToHotel(DTOHotel dtoHotel){
        Hotel hotel = new Hotel(dtoHotel.getName(), dtoHotel.getAddress(), dtoHotel.getStars());
        return hotel;
    }

    public static DTOHotel transformHotelToDTOHotel(Hotel hotel){
        DTOHotel dtoHotel = new DTOHotel(hotel.getName(), hotel.getAddress(), hotel.getStars());
        return dtoHotel;
    }
}
