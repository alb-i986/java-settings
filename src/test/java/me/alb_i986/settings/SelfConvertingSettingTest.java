package me.alb_i986.settings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SelfConvertingSettingTest {

    @Mock private SelfValidatingSetting mockedSetting;
    @Mock private SettingConverter<URL> mockedConverter;

    @Test
    public void value_given() {
        String value = "value";
        given(mockedSetting.value()).willReturn(value);
        URL url = null;
        try {
            url = new URL("http://google.it");
        } catch (MalformedURLException e) {
            fail(e.toString());
        }
        given(mockedConverter.convert(value)).willReturn(url);
        SelfConvertingSetting<URL> sut = new SelfConvertingSetting<URL>(mockedSetting, mockedConverter);

        URL actualValue = sut.value();

        assertEquals(url, actualValue);
    }

}