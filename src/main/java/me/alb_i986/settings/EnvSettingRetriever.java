package me.alb_i986.settings;

/**
 * @author ascotto
 */
public class EnvSettingRetriever implements SettingRetriever {
    @Override
    public String retrieve(String key) {
        return System.getenv(key);
    }
}
