package ru.gus.propimport;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SettingsTest {

    @Test
    public void whenLoadViaPathThenTrue() {
        Settings set = new Settings();
        set.load(ClassLoader.getSystemResourceAsStream("app.properties"));
        String result = set.getValue("test.dir");
        assertThat(result, is("c:\\temp"));
    }

    @Test
    public void whenLoadViaNameThenTrue() {
        Settings set = new Settings();
        set.loadFromResources("app.properties");
        String result = set.getValue("test.dir");
        assertThat(result, is("c:\\temp"));
    }
}