package me.alb_i986.settings.core;

import me.alb_i986.settings.core.retrievers.EnvSettingRetriever;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class EnvSettingRetrieverTest {

    private final EnvSettingRetriever sut = new EnvSettingRetriever();

    @Test
    public void testNormalizeKeyWithDots() {
        String key = "my.prop";
        String key2 = sut.normalizeKey(key);
        assertThat(key2, equalTo("MY_PROP"));
    }

    @Test
    public void testNormalizeKeyWithNoDots() {
        String key = "myprop";
        String key2 = sut.normalizeKey(key);
        assertThat(key2, equalTo("MYPROP"));
    }
}