package ru.gus.factory;

import org.junit.Test;


public class FactoryTest {

    @Test
    public void digitalTest() {
        WatchMaker maker = new DigitalWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }

    @Test
    public void romeTest() {
        WatchMaker maker = new RomeWatchMaker();
        Watch watch = maker.createWatch();
        watch.showTime();
    }
}