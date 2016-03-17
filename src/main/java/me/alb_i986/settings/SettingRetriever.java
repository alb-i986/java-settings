package me.alb_i986.settings;

public interface SettingRetriever {

    /**
     * @param key
     * @return null if the setting is not defined
     */
    String retrieve(String key);
}
