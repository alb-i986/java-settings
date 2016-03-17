package me.alb_i986.settings;

import me.alb_i986.settings.validators.SettingValidator;
import me.alb_i986.settings.validators.SettingValidators;

public abstract class BaseSetting<T> implements Setting<T> {

    /*
    Class invariants:
    - key is not null
    - retriever is not null
     */

    private final String key;
    private T value;

    private final SettingRetriever retriever;
    private SettingValidator validator = SettingValidators.NULL_VALIDATOR;
    private SettingConverter<T> converter;

    /**
     * If null and retrieved==true, it means that this is an undefined setting.
     */

    /**
     * If true, {@link #value} will contain the actual value retrieved.
     */
    private boolean retrieved;

    public BaseSetting(String key, SettingRetriever retriever) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("key must not be null nor empty");
        }
        if (retriever == null) {
            throw new IllegalArgumentException("retriever must not be null");
        }
        this.key = key;
        this.retriever = retriever;
        this.converter = converter();
    }

    protected abstract SettingConverter<T> converter();

    public Setting<T> withValidator(SettingValidator validator) {
        this.validator = validator;
        return this;
    }

    public String key() {
        return key;
    }

    public T value() {
        if (!retrieved) {
            String rawValue = retriever.retrieve(key);
            validator.validate(rawValue);
            value = converter.convert(rawValue);
            retrieved = true;
        }
        return value;
    }

    public boolean isDefined() {
        return value() != null;
    }
}
