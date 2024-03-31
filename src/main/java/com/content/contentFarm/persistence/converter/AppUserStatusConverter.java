package com.content.contentFarm.persistence.converter;

import com.content.constant.AppUserStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AppUserStatusConverter implements AttributeConverter<AppUserStatus, String> {

    @Override
    public String convertToDatabaseColumn(AppUserStatus appUserStatus) {
        return appUserStatus.getCodeInDB();
    }

    @Override
    public AppUserStatus convertToEntityAttribute(String dbData) {
        return AppUserStatus.toValue(dbData);
    }
}
