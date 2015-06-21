package me.alb_i986.settings;

public interface SettingConverter<T> {

    T convert(String value);
}
