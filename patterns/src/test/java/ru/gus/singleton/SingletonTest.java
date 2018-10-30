package ru.gus.singleton;

import org.junit.Test;


public class SingletonTest {

    @Test
    public void whenCreatesThousandThreadsThanCounterIsOne() throws InterruptedException {
        final int SIZE = 1000;

        Thread[] t = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(Singleton::getInstance);
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t[i].join();
        }
        System.out.println(Singleton.counter);
    }
}