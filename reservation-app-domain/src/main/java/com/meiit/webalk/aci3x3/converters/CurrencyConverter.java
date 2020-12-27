package com.meiit.webalk.aci3x3.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.meiit.webalk.aci3x3.Currency;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class CurrencyConverter implements AttributeConverter<Currency, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Currency currency) {
        if(currency == null){
            return null;
        }
        return currency.getCode();
    }

    @Override
    public Currency convertToEntityAttribute(Integer code) {
        if(code == null){
            return null;
        }
        return Stream.of(Currency.values()).filter(c -> c.getCode().equals(code)).findFirst().orElseThrow();
    }
}
