package me.alb_i986.settings.core;

public class InvalidSettingException extends SettingException {

    public InvalidSettingException(String invalidValue, String reason) {
        this(invalidValue, reason, this);
    }

    public InvalidSettingException(String invalidValue, String reason, Throwable cause) {
        super("Setting should " + reason + " but was: " + invalidValue, cause);
    }

}
