package me.alb_i986.settings;

public abstract class SettingDecorator<T> implements Setting<T> {

    protected Setting<T> setting;

    public SettingDecorator(Setting<T> setting) {
        this.setting = setting;
    }

    public String key() {
        return setting.key();
    }

    public boolean isDefined() {
        return setting.isDefined();
    }
}
