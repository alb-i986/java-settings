package me.alb_i986.settings.core;

public abstract class BaseSettingValidator<T> {

    /**
     * @throws InvalidSettingException if the validation fails
     */
    public void validate(T value) {
        if (!condition()) {
            throw new InvalidSettingException(value, );
        }
    }

    protected abstract boolean condition();
}
