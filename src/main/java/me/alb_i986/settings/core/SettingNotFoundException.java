package me.alb_i986.settings.core;

public class SettingNotFoundException extends SettingException {

    public SettingNotFoundException(String message) {
        super(message);
    }

    public SettingNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingNotFoundException(Throwable cause) {
        super(cause);
    }
}

