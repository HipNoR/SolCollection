package ru.gus.singleton;

/**
 * Simple threadsafe Singleton.
 * Only one instance of class is exists.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 30.10.2018
 */
public class Singleton {
    public static int counter = 0;
    private static volatile Singleton instance;

    private Singleton() {
        counter++;
    }


    /**
     * Checks if an instance exists.
     *  If false creates a new instance, otherwise returns an existing one.
     * @return single instance of class.
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
