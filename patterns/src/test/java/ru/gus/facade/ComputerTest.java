package ru.gus.facade;

import org.junit.Test;


public class ComputerTest {

    @Test
    public void whenNotUseFacade() {
        Power power = new Power();
        DVDRom dvd = new DVDRom();
        HDD hdd = new HDD();
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
        dvd.unload();
        power.off();
    }

    @Test
    public void whenUseFacadeThenShorter() {
        Computer computer = new Computer();
        computer.copy();
    }
}