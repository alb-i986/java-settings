package me.alb_i986.settings;

public interface SettingValidator {

    /**
     * @throws RuntimeException (a subclass) if the validation fails
     */
    void validate(String value);
}
