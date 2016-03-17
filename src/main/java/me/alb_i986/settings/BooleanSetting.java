package me.alb_i986.settings;

import me.alb_i986.settings.core.BaseSetting;
import me.alb_i986.settings.core.BaseSettingConverter;
import me.alb_i986.settings.core.SettingConverter;
import me.alb_i986.settings.core.retrievers.SettingRetriever;

/**
 * @author ascotto
 */
public class BooleanSetting extends BaseSetting<Boolean> {

    public BooleanSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<Boolean> converter() {
        return new BaseSettingConverter<Boolean>() {
            @Override
            public Boolean convert0(String value) throws Exception {
                return Boolean.valueOf(value);
            }
        };
    }
}
