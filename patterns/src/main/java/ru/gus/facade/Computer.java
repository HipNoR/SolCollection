package ru.gus.facade;

/**
 * facade class.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 18.10.2018
 */
public class Computer {
    private Power power = new Power();
    private DVDRom dvd = new DVDRom();
    private HDD hdd = new HDD();

    public void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
        dvd.unload();
        power.off();
    }
}
