package me.alb_i986.settings;

/**
 * @author ascotto
 */
public class SettingException extends RuntimeException {

    public SettingException(String message) {
        super(message);
    }

    public SettingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SettingException(Throwable cause) {
        super(cause);
    }
}
