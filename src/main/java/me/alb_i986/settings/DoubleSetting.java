package me.alb_i986.settings;

import me.alb_i986.settings.core.BaseSetting;
import me.alb_i986.settings.core.BaseSettingConverter;
import me.alb_i986.settings.core.SettingConverter;
import me.alb_i986.settings.core.retrievers.SettingRetriever;

/**
 * @author ascotto
 */
public class DoubleSetting extends BaseSetting<Double> {

    public DoubleSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<Double> converter() {
        return new BaseSettingConverter<Double>() {
            @Override
            public Double convert0(String value) {
                return Double.valueOf(value);
            }
        };
    }
}
