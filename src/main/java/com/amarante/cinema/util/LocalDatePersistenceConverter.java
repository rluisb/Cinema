package com.amarante.cinema.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDatePersistenceConverter implements AttributeConverter<LocalDate, Date> {

	public Date convertToDatabaseColumn(LocalDate locDate) {
		return (locDate == null ? null : Date.valueOf(locDate));
	}

	public LocalDate convertToEntityAttribute(Date sqlDate) {
		return (sqlDate == null ? null : sqlDate.toLocalDate());
	}
}
