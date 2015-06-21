package me.alb_i986.settings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BaseSettingTest {

    @Mock private SettingRetriever mockedRetriever;

    @Test
    public void value_givenDefinedKey() {
        String key = "defined key";
        String value = "value";
        given(mockedRetriever.retrieve(key)).willReturn(value);
        BaseSetting sut = new BaseSetting(key, mockedRetriever);

        String actualValue = sut.value();

        assertEquals(value, actualValue);
    }

    @Test
    public void value_givenUndefinedKey() {
        String key = "undefined key";
        given(mockedRetriever.retrieve(key)).willReturn(null);
        BaseSetting sut = new BaseSetting(key, mockedRetriever);

        String actualValue = sut.value();

        assertNull(actualValue);
    }

    @Test
    public void value_shouldBeCachedTheFirstTime() {
        String key = "valid_key";
        String value = "value";
        given(mockedRetriever.retrieve(key)).willReturn(value);
        BaseSetting sut = new BaseSetting(key, mockedRetriever);

        sut.value();
        sut.value();

        verify(mockedRetriever).retrieve(key);
        verifyNoMoreInteractions(mockedRetriever);
    }

    public void isDefined_givenDefinedKey() {
        String key = "defined key";
        given(mockedRetriever.retrieve(key)).willReturn("value");
        BaseSetting sut = new BaseSetting(key, mockedRetriever);

        assertTrue(sut.isDefined());
    }

    public void isDefined_givenUndefinedKey() {
        String key = "undefined key";
        given(mockedRetriever.retrieve(key)).willReturn(null);
        BaseSetting sut = new BaseSetting(key, mockedRetriever);

        assertFalse(sut.isDefined());
    }

}