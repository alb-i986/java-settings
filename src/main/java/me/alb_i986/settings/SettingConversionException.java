package me.alb_i986.settings;

public class SettingConversionException extends SettingException {

    public SettingConversionException(String message) {
        super(message);
    }

    public SettingConversionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingConversionException(Throwable cause) {
        super(cause);
    }
}

