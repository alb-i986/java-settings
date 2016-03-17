package me.alb_i986.settings;

import me.alb_i986.settings.core.BaseSetting;
import me.alb_i986.settings.core.BaseSettingConverter;
import me.alb_i986.settings.core.SettingConverter;
import me.alb_i986.settings.core.retrievers.SettingRetriever;

/**
 * @author ascotto
 */
public class StringSetting extends BaseSetting<String> {

    public StringSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<String> converter() {
        return new BaseSettingConverter<String>() {
            @Override
            public String convert0(String value) {
                return value;
            }
        };
    }
}
