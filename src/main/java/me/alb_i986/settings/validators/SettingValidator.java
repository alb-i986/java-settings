package me.alb_i986.settings.validators;

public interface SettingValidator {

    /**
     * @throws me.alb_i986.settings.InvalidSettingException if the validation fails
     */
    void validate(String value);
}
