package com.meiit.webalk.aci3x3.web.dtos;

import com.meiit.webalk.aci3x3.Currency;
import com.meiit.webalk.aci3x3.Room;
import com.meiit.webalk.aci3x3.Wing;
import com.meiit.webalk.aci3x3.services.rest.RestEndpointService;

import java.math.BigDecimal;

public class DTORoomTransformer {

    public static Room transformDTORoomRestToRoom(DTORoomRest dtoRoomRest, RestEndpointService restEndpointService){
        System.out.println("dtoRoomRest: "+dtoRoomRest);
        System.out.println("restEndpointService: "+restEndpointService);
        Wing wing = restEndpointService.getWingById(dtoRoomRest.getWing_id());
        Room room = new Room(
                dtoRoomRest.getNumber(),
                dtoRoomRest.getBeds(),
                dtoRoomRest.isBalcon(),
                wing,
                dtoRoomRest.getPrice(),
                dtoRoomRest.getCurrency()
        );
        return room;
    }
    
    
    
    
    
    

    public static Room transformDTORoomToRoom(DTORoom dtoRoom){
        Room room = new Room(
                dtoRoom.getId(),
                dtoRoom.getNumber(),
                dtoRoom.getBeds(),
                dtoRoom.isBalcon(),
                dtoRoom.getWing(),
                dtoRoom.getPrice(),
                dtoRoom.getCurrency()
        );
        return room;
    }

    
    
    public static DTORoom transformRoomToDTORoom(Room room){
        DTORoom dtoRoom = new DTORoom(
                room.getId(),
                room.getNumber(),
                room.getBeds(),
                room.isBalcon(),
                room.getWing(),
                room.getPrice(),
                room.getCurrency()
        );
        return dtoRoom;
    }
}
