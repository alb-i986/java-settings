package me.alb_i986.settings.core;

import me.alb_i986.settings.StringSetting;
import me.alb_i986.settings.core.retrievers.SettingRetriever;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class BaseSettingTest {

    @Mock private SettingRetriever mockedRetriever;

    @Test
    public void value_givenDefinedKey() {
        String key = "defined key";
        String value = "value";
        given(mockedRetriever.retrieve(key)).willReturn(value);
        StringSetting sut = new StringSetting(key, mockedRetriever);

        String actualValue = sut.value();

        verify(mockedRetriever).retrieve(key);
        assertThat(actualValue, equalTo(value));
    }

    @Test
    public void value_givenUndefinedKey() {
        String undefinedKey = "undefined key";
        given(mockedRetriever.retrieve(undefinedKey)).willReturn(null);
        StringSetting sut = new StringSetting(undefinedKey, mockedRetriever);

        String actualValue = sut.value();

        assertNull(actualValue);
    }

    @Test
    public void value_shouldBeCachedTheFirstTime() {
        String key = "valid_key";
        String value = "value";
        given(mockedRetriever.retrieve(key)).willReturn(value);
        StringSetting sut = new StringSetting(key, mockedRetriever);

        sut.value();
        sut.value();

        verify(mockedRetriever).retrieve(key);
        verifyNoMoreInteractions(mockedRetriever);
    }

    public void isDefined_givenDefinedKey() {
        String key = "defined key";
        given(mockedRetriever.retrieve(key)).willReturn("value");
        StringSetting sut = new StringSetting(key, mockedRetriever);

        assertTrue(sut.isDefined());
    }

    public void isDefined_givenUndefinedKey() {
        String key = "undefined key";
        given(mockedRetriever.retrieve(key)).willReturn(null);
        StringSetting sut = new StringSetting(key, mockedRetriever);

        assertFalse(sut.isDefined());
    }
}