package ru.gus.propimport;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties loader from resource folder.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 26.10.2018
 */
public class Settings {
    private final Properties prop = new Properties();

    public void load(InputStream is) {
        try {
            this.prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromResources(String prop) {
        try (InputStream is = ClassLoader.getSystemResourceAsStream(prop)) {
            this.prop.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getValue(String key) {
        return this.prop.getProperty(key);
    }


}
