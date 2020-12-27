package com.meiit.webalk.aci3x3.web.dtos;

import java.math.BigDecimal;

import com.meiit.webalk.aci3x3.Currency;

public class DTORoomRest {

    private boolean balcon;
    private Integer beds;
    private Currency currency;
    private Integer number;
    private BigDecimal price;
    private Long wing_id;

    public DTORoomRest(){
        super();
    }


    public boolean isBalcon() {
        return balcon;
    }

    public void setBalcon(boolean balcon) {
        this.balcon = balcon;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getWing_id() {
        return wing_id;
    }

    public void setWing_id(Long wing_id) {
        this.wing_id = wing_id;
    }
}
