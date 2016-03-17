package me.alb_i986.settings.core;

public interface SettingConverter<T> {

    /**
     * @throws SettingConversionException
     */
    T convert(String value);
}
