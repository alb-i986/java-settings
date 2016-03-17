package me.alb_i986.settings.core;

import me.alb_i986.settings.core.retrievers.HierarchicalSettingRetriever;
import me.alb_i986.settings.core.retrievers.SettingRetriever;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HierarchicalSettingRetrieverTest {

    private HierarchicalSettingRetriever sut;
    @Mock
    SettingRetriever retriever1;
    @Mock SettingRetriever retriever2;

    @Test
    public void testRetrieveGivenSettingIsDefinedInTheFirstSource() {
        String key = "key";
        sut = new HierarchicalSettingRetriever(retriever1, retriever2);
        given(retriever1.retrieve(key)).willReturn("value");
        given(retriever2.retrieve(key)).willReturn("value");

        // when
        String value = sut.retrieve(key);

        // then
        assertThat(value, equalTo("value"));
        verify(retriever1).retrieve(key);
        verify(retriever2, never()).retrieve(key);
    }

    @Test
    public void testRetrieveGivenSettingIsDefinedInTheSecondSource() {
        String key = "key";
        sut = new HierarchicalSettingRetriever(retriever1, retriever2);
        given(retriever1.retrieve(key)).willReturn(null);
        given(retriever2.retrieve(key)).willReturn("value");

        // when
        String value = sut.retrieve(key);

        // then
        assertThat(value, equalTo("value"));
        verify(retriever1).retrieve(key);
        verify(retriever2).retrieve(key);
    }

    @Test
    public void testRetrieveGivenSettingIsNotDefinedInAnySource() {
        String key = "key";
        sut = new HierarchicalSettingRetriever(retriever1, retriever2);
        given(retriever1.retrieve(key)).willReturn(null);
        given(retriever2.retrieve(key)).willReturn(null);

        // when
        String value = sut.retrieve(key);

        // then
        assertThat(value, nullValue());
        verify(retriever1).retrieve(key);
        verify(retriever2).retrieve(key);
    }
}