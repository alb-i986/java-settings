package me.alb_i986.settings.core;

import java.util.regex.Pattern;

public class SettingValidators {

    public static final SettingValidator NULL_VALIDATOR = new SettingValidator<?>() {
        @Override
        public void validate(String value) {
        }
    };

    public static final SettingValidator REGEX_VALIDATOR(final String regex) {
        return new BaseSettingValidator<String>() {
            @Override
            public void validate(String value) {
                Pattern pattern = Pattern.compile(regex);
                if (!pattern.matcher(value).matches()) {
                    throw new InvalidSettingException(String.format("The value '%s' does not match with the regex '%s'", value, regex));
                }
            }

            @Override
            protected String reason() {
                return "";
            }

            @Override
            protected boolean isValid(String value) {
                Pattern pattern = Pattern.compile(regex);
                return pattern.matcher(value).matches();
            }

        };
    }

    public static final SettingValidator REQUIRED_SETTING_VALIDATOR() {
        return new SettingValidator() {
            @Override
            public void validate(String value) {
                if (value == null) {
                    throw new InvalidSettingException("The setting is required but is not defined");
                }
            }
        };
    }
}
