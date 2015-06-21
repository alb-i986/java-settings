package me.alb_i986.settings;

public class BaseSetting implements Setting<String> {

    /*
    Class invariants:
    - key is not null
    - retriever is not null
     */

    private String key;
    private SettingRetriever retriever;

    /**
     * If null and retrieved==true, it means that this is an undefined setting.
     */
    private String value;

    /**
     * If true, {@link #value} will contain the actual value retrieved.
     */
    private boolean retrieved;

    public BaseSetting(String key, SettingRetriever retriever) {
        if (key == null) {
            throw new IllegalArgumentException("key must not be null");
        }
        if (retriever == null) {
            throw new IllegalArgumentException("retriever must not be null");
        }
        this.key = key;
        this.retriever = retriever;
    }

    public String key() {
        return this.key;
    }

    public String value() {
        if (!retrieved) {
            value = retriever.retrieve(key);
            retrieved = true;
        }
        return value;
    }

    public boolean isDefined() {
        return value() != null;
    }
}
