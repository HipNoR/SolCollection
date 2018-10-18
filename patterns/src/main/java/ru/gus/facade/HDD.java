package ru.gus.facade;

/**
 * HDD class.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 18.10.2018
 */
public class HDD {

    public void copyFromDVD(DVDRom dvd) {
        if (dvd.isData()) {
            System.out.println("Coping data");
        } else {
            System.out.println("Insert DVD");
        }
    }
}
