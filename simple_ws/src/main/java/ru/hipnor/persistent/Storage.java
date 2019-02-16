package ru.hipnor.persistent;

import java.util.ArrayList;

/**
 * //TODO comment
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.02.2019
 */
public interface Storage<T> {

     void addElement(T element);

     ArrayList<T> getElements();
}
