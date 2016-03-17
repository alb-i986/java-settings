package me.alb_i986.settings.core;

import me.alb_i986.settings.IntSetting;
import me.alb_i986.settings.core.retrievers.SettingRetriever;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class SettingsIT {

    private static SettingRetriever retriever = mock(SettingRetriever.class);
    private static Setting<Integer> done = new IntSetting("done", retriever)
            .withPostConversionValidator(new SettingValidator<Integer>() {
                @Override
                public void validate(Integer value) {
                    value
                }
            });
    @Test
    public void settings() {

    }
}
