package me.alb_i986.settings;

public interface SettingConverter<T> {

    /**
     * @throws SettingConversionException
     */
    T convert(String value);
}
