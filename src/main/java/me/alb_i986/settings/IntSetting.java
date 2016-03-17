package me.alb_i986.settings;

import me.alb_i986.settings.core.BaseSetting;
import me.alb_i986.settings.core.BaseSettingConverter;
import me.alb_i986.settings.core.SettingConverter;
import me.alb_i986.settings.core.retrievers.SettingRetriever;

/**
 * @author ascotto
 */
public class IntSetting extends BaseSetting<Integer> {

    public IntSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<Integer> converter() {
        return new BaseSettingConverter<Integer>() {
            @Override
            public Integer convert0(String value) {
                return Integer.valueOf(value);
            }
        };
    }
}
