package me.alb_i986.settings.core;

public abstract class BaseSettingValidator<T> implements SettingValidator<T> {

    /**
     * @throws InvalidSettingException if the validation fails
     */
    public void validate(T value) {
        if (!isValid(value)) {
            throw new InvalidSettingException(value.toString(), reason());
        }
    }

    protected abstract String reason();

    protected abstract boolean isValid(T value);
}
