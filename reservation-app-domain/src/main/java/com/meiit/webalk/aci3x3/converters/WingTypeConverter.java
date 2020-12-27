package com.meiit.webalk.aci3x3.converters;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.meiit.webalk.aci3x3.WingType;

@Converter(autoApply = true)
public class WingTypeConverter implements AttributeConverter<WingType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WingType wingType) {
        if(wingType == null){
            return null;
        }
        return wingType.getCode();
    }

    @Override
    public WingType convertToEntityAttribute(Integer code) {
        if(code == null){
            return null;
        }
        return Stream.of(WingType.values()).filter(c -> c.getCode().equals(code)).findFirst().orElseThrow();
    }
}
