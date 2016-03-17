package me.alb_i986.settings.core;

import me.alb_i986.settings.core.retrievers.SettingRetriever;

/**
 * Concrete settings need to define the {@link #converter()}.
 *
 * @param <T> the type of the value of this setting
 */
public abstract class BaseSetting<T> implements Setting<T> {

    private final String key;
    private T value;

    private final SettingRetriever retriever;
    private SettingValidator<String> preConversionValidator = SettingValidators.NULL_VALIDATOR;
    private SettingValidator<T> postConversionValidator = SettingValidators.NULL_VALIDATOR;
    private SettingConverter<T> converter;

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

    @Override
    public String key() {
        return key;
    }

    @Override
    public T value() {
        if (!retrieved) {
            retrieved = true;
            String rawValue = retriever.retrieve(key);
            preConversionValidator.validate(rawValue);
            if (rawValue == null) {
                value = null;
            } else {
                value = converter.convert(rawValue);
                postConversionValidator.validate(value);
            }
        }
        return value;
    }

    @Override
    public boolean isDefined() {
        return value() != null;
    }

    protected abstract SettingConverter<T> converter();

    public Setting<T> withPreConversionValidator(SettingValidator<String> validator) {
        this.preConversionValidator = validator;
        return this;
    }
    public Setting<T> withPostConversionValidator(SettingValidator<T> validator) {
        this.postConversionValidator = validator;
        return this;
    }
}
