package me.alb_i986.settings.core.retrievers;

/**
 * @author ascotto
 */
public class SystemPropertySettingRetriever implements SettingRetriever {
    @Override
    public String retrieve(String key) {
        return System.getProperty(key);
    }
}