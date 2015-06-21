package me.alb_i986.settings;

import java.net.MalformedURLException;
import java.net.URL;

public class SettingConverters {
    public static final SettingConverter<URL> TO_URL = new SettingConverter<URL>() {
        @Override
        public URL convert(String value) {
            try {
                return new URL(value);
            } catch (MalformedURLException e) {
                throw new SettingConversionException(e);
            }
        }
    };
}
