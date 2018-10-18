package ru.gus.facade;

/**
 * DVDRom class.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 18.10.2018
 */
public class DVDRom {
    private boolean data = false;

    public boolean isData() {
        return data;
    }

    public void load() {
        data = true;
        System.out.println("DVD loaded");
    }

    public void unload() {
        data = false;
        System.out.println("DVD unloaded");
    }
}
