package ru.gus.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SingletonEnumTest {

    @Test
    public void firstTest() throws InterruptedException {
        long first = SingletonEnum.INSTANCE.getTime();
        Thread.sleep(100);
        long second = SingletonEnum.INSTANCE.getTime();
        assertThat(first, is(second));
    }
}