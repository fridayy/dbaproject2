package at.fhj.swd.persistence;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalDate;

@Converter(autoApply = true)
public class LocalDatePersistanceConverter implements AttributeConverter<LocalDate, java.sql.Date> {

    @Override
    public java.sql.Date convertToDatabaseColumn(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }

    @Override
    public LocalDate convertToEntityAttribute(java.sql.Date date) {
        return date.toLocalDate();
    }
}
