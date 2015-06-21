package me.alb_i986.settings;

public class SelfConvertingSetting<T> extends SettingDecorator<T> {

    private SettingConverter<T> converter;

    public SelfConvertingSetting(SelfValidatingSetting setting, SettingConverter<T> converter) {
        super((Setting<T>) setting);
        this.converter = converter;
    }

    @Override
    public T value() {
        return converter.convert((String) setting.value());
    }
}
