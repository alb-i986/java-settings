package me.alb_i986.settings.core;

public interface SettingValidator<T> {

    /**
     * @throws InvalidSettingException if the validation fails
     */
    void validate(T value);
}
