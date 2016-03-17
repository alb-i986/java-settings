package me.alb_i986.settings;

import me.alb_i986.settings.core.BaseSetting;
import me.alb_i986.settings.core.BaseSettingConverter;
import me.alb_i986.settings.core.SettingConverter;
import me.alb_i986.settings.core.retrievers.SettingRetriever;

import java.net.URL;

/**
 * @author ascotto
 */
public class URLSetting extends BaseSetting<URL> {

    public URLSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<URL> converter() {
        return new BaseSettingConverter<URL>() {
            @Override
            public URL convert0(String value) throws Exception {
                return new URL(value);
            }
        };
    }
}
