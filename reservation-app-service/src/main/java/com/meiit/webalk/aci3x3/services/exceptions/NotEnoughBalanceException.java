package com.meiit.webalk.aci3x3.services.exceptions;

import java.math.BigDecimal;

public class NotEnoughBalanceException extends Exception{

    private BigDecimal balance;
    private BigDecimal required;
    private String message;

    public NotEnoughBalanceException(BigDecimal balance, BigDecimal required){
        this.balance = balance;
        this.required = required;
        StringBuilder sb = new StringBuilder();
        sb.append("Not enough balance! Balance: ");
        sb.append(this.balance);
        sb.append("; Required: ");
        sb.append(this.required);
        sb.append("; Missing: ");
        sb.append(this.required.subtract(this.balance));
        this.message = sb.toString();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getRequired() {
        return required;
    }

    public void setRequired(BigDecimal required) {
        this.required = required;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
