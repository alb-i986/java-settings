package me.alb_i986.settings;

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
