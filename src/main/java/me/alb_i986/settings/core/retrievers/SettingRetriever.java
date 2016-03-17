package me.alb_i986.settings.core.retrievers;

public interface SettingRetriever {

    /**
     * @param key
     * @return null if the setting is not defined
     */
    String retrieve(String key);
}
