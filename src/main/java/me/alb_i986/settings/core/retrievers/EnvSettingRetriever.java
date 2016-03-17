package me.alb_i986.settings.core.retrievers;

/**
 *
 * @author ascotto
 */
public class EnvSettingRetriever implements SettingRetriever {

    @Override
    public String retrieve(String key) {
        return System.getenv(normalizeKey(key));
    }

    protected String normalizeKey(String key) {
        return key.toUpperCase().replaceAll("\\.", "_");
    }
}
