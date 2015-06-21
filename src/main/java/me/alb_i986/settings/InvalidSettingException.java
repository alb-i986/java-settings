package me.alb_i986.settings;

public class InvalidSettingException extends RuntimeException {

    public InvalidSettingException() {
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
