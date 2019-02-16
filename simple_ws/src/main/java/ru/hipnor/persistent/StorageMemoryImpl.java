package ru.hipnor.persistent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

/**
 * Реализация простого хранилища стрингов.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version $
 * @since 0.1
 * 16.02.2019
 */
public class StorageMemoryImpl<T> implements Storage<T> {
    private static final Logger LOG = LogManager.getLogger(StorageMemoryImpl.class.getName());

    private final ArrayList<T> storage = new ArrayList<>();

    @Override
    public void addElement(T element) {
        this.storage.add(element);
        LOG.info(element + " added to storage");
    }

    @Override
    public ArrayList<T> getElements() {
        return this.storage;
    }
}
