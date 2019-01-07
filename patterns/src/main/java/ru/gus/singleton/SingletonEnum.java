package ru.gus.singleton;

/**
 * Simple threadsafe Singleton.
 * Only one instance of class is exists.
 * ENUM singleton.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 07.01.2019
 */

public enum SingletonEnum {
    INSTANCE;

    private long time = System.currentTimeMillis();

    public synchronized long getTime() {
        return time;
    }
}
