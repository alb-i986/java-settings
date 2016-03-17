package me.alb_i986.settings;

/**
 * @author ascotto
 */
public class StringSetting extends BaseSetting<String> {

    public StringSetting(String key, SettingRetriever retriever) {
        super(key, retriever);
    }

    @Override
    protected SettingConverter<String> converter() {
        return new SettingConverter<String>() {
            @Override
            public String convert(String value) {
                return value;
            }
        };
    }
}
