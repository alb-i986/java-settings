package me.alb_i986.settings;

import me.alb_i986.settings.core.BaseSetting;
import me.alb_i986.settings.core.BaseSettingConverter;
import me.alb_i986.settings.core.SettingConverter;
import me.alb_i986.settings.core.retrievers.SettingRetriever;

/**
 * @author ascotto
 */
public class LongSetting extends BaseSetting<Long> {

    public LongSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<Long> converter() {
        return new BaseSettingConverter<Long>() {
            @Override
            public Long convert0(String value) {
                return Long.valueOf(value);
            }
        };
    }
}
