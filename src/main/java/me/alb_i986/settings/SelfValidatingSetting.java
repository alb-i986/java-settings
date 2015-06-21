package me.alb_i986.settings;

public class SelfValidatingSetting extends SettingDecorator<String> {

    private SettingValidator validator;

    public SelfValidatingSetting(BaseSetting setting) {
        this(setting, null);
    }

    public SelfValidatingSetting(BaseSetting setting, SettingValidator validator) {
        super(setting);
        this.validator = (validator == null ? SettingValidators.NULL_VALIDATOR : validator);
    }

    /**
     * @return the value as returned by the delegate
     * @throws InvalidSettingException if the setting is not valid
     */
    public String value() {
        String value = setting.value();
        try {
            validator.validate(value);
        } catch (Exception e) {
            throw new InvalidSettingException(e);
        }
        return value;
    }
}
