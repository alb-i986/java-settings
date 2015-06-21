package me.alb_i986.settings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.willThrow;

@RunWith(MockitoJUnitRunner.class)
public class SelfValidatingSettingTest {

    @Mock private SettingValidator mockedValidator;
    @Mock private BaseSetting mockedBaseSetting;

    @Test
    public void value_givenPassingValidator() {
        String validValue = "valid value";
        given(mockedBaseSetting.value()).willReturn(validValue);
        willDoNothing().given(mockedValidator).validate(validValue);
        SelfValidatingSetting sut = new SelfValidatingSetting(mockedBaseSetting, mockedValidator);

        String actualValue = sut.value();

        assertEquals(validValue, actualValue);
    }

    @Test(expected = InvalidSettingException.class)
    public void value_givenFailingValidator() {
        String value = "value";
        given(mockedBaseSetting.value()).willReturn(value);
        willThrow(NumberFormatException.class).given(mockedValidator).validate(value);
        SelfValidatingSetting sut = new SelfValidatingSetting(mockedBaseSetting, mockedValidator);

        // when
        sut.value();

        // then throw ex
    }

}