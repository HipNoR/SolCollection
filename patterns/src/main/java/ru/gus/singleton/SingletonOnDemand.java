package ru.gus.singleton;


/**
 * Simple threadsafe Singleton.
 * Only one instance of class is exists.
 * On Demand Holder idiom.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 07.01.2019
 */
public class SingletonOnDemand {

    public static class SingletonHolder {
        public static final SingletonOnDemand HOLDER_INSTANCE = new SingletonOnDemand();
    }

    public static SingletonOnDemand getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

}
