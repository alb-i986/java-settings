package me.alb_i986.settings;

/**
 * @author ascotto
 */
public class SystemPropertySettingRetriever implements SettingRetriever {
    @Override
    public String retrieve(String key) {
        return System.getProperty(key);
    }
}
