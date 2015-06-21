package me.alb_i986.settings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class SelfConvertingSettingIT {

    @Mock private SettingRetriever mockedRetriever;

    @Test
    public void value_givenConvertableValue() {
        String key = "key";
        SelfValidatingSetting setting = new SelfValidatingSetting(
                new BaseSetting(key, mockedRetriever)
        );
        String value = "http://google.it";
        given(mockedRetriever.retrieve(key)).willReturn(value);
        SelfConvertingSetting<URL> sut = new SelfConvertingSetting<URL>(setting, SettingConverters.TO_URL);

        URL actualValue = sut.value();

        try {
            URL expected = new URL(value);
            assertEquals(expected, actualValue);
        } catch (MalformedURLException e) {
            fail(e.toString());
        }
    }

}