package com.meiit.webalk.aci3x3.web.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.meiit.webalk.aci3x3.Currency;

public class DTOBookingPersonRest {

    private String email;
    private String password;
    private String name;
    private Integer account;
    private BigDecimal balance;
    private String birth;
    private Currency currency;

    public DTOBookingPersonRest(){
        super();
    }
    public DTOBookingPersonRest(String email,
    		String password,
    		String name,
    		Integer account,
    		BigDecimal balance,
    		String birth,
    		Currency currency){
        super();
        this.email = email;
        this.name = name;
        this.account = account;
        this.balance = balance;
        this.birth = birth;
        this.currency = currency;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }
    
    

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPassword() {
        return password;
    }
    
    

    public void setPassword(String password) {
        this.password = password;
    }
}
