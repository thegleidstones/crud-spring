package com.gleidsonsilva.crud_spring.enums.converters;

import com.gleidsonsilva.crud_spring.enums.Status;
import jakarta.persistence.AttributeConverter;

import java.util.stream.Stream;

public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        
        return status.getValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if (value == null) {
            return null;            
        }
        return Stream.of(Status.values())
                .filter(s -> s.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
