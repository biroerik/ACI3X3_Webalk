package com.meiit.webalk.aci3x3.web.dtos;

import javax.persistence.ManyToOne;

import com.meiit.webalk.aci3x3.Currency;
import com.meiit.webalk.aci3x3.Wing;

import java.math.BigDecimal;

public class DTORoom {
    private Long id;
    private Integer number;
    private Integer beds;
    private boolean balcon;
    private Wing wing;
    private BigDecimal price;
    private Currency currency;

    public DTORoom(){
        super();
    }

    public DTORoom(Long id, Integer number, Integer beds, boolean balcon, Wing wing, BigDecimal price, Currency currency) {
        super();
        this.id = id;
        this.number = number;
        this.beds = beds;
        this.balcon = balcon;
        this.wing = wing;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room number: ");
        sb.append(number);
        sb.append("; with ");
        sb.append(beds);
        sb.append(" beds and ");
        if(balcon){
            sb.append("balcony ");
        }
        else{
            sb.append("no balcony ");
        }
        sb.append("; Price: ");
        sb.append(price);
        sb.append(" ");
        sb.append(currency);
        return sb.toString();
    }

    public Wing getWing() {
        return wing;
    }

    public void setWing(Wing wing) {
        this.wing = wing;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public Integer getBeds() {
        return beds;
    }
    public void setBeds(Integer beds) {
        this.beds = beds;
    }
    public boolean isBalcon() {
        return balcon;
    }
    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    //TODO getter and setter test and remove for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
