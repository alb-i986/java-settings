package me.alb_i986.settings.core;

public class InvalidSettingException extends SettingException {

    public InvalidSettingException(String invalidValue, String reason) {
        super("Setting should " + reason + " but was: " + invalidValue);
    }

    public InvalidSettingException(String message) {
        super(message);
    }

    public InvalidSettingException(Throwable cause) {
        super(cause);
    }

    public InvalidSettingException(String message, Throwable cause) {
        super(message, cause);
    }
}
