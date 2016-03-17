package me.alb_i986.settings.core;

public interface SettingValidator {

    /**
     * @throws InvalidSettingException if the validation fails
     */
    void validate(String value);
}
