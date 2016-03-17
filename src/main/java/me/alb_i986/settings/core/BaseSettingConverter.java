package me.alb_i986.settings.core;

public abstract class BaseSettingConverter<T> implements SettingConverter<T> {

    /**
     * @throws SettingConversionException in case the value cannot be converted to type {@code T}
     */
    public T convert(String value) {
        try {
            return convert0(value);
        } catch (Exception e) {
            throw new SettingConversionException("Conversion failed. Value: '" + value + "'", e);
        }
    }

    /**
     * Override this to define the actual conversion logic.
     */
    protected abstract T convert0(String value) throws Exception;
}
