package com.meiit.webalk.aci3x3.web.dtos;

public class DTOHotel {
    private String name;
    private String address;
    private Integer stars;

    public DTOHotel(){
        super();
    }
    public DTOHotel(String name, String address, Integer stars){
        this.name = name;
        this.address = address;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    
    
    
    

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }
}
