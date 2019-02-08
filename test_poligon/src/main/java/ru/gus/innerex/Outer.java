package ru.gus.innerex;

/**
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 22.01.2019
 */
public class Outer {

    private int outX = 100;

    void test() {
        Inner inner = new Inner();
        inner.display();
    }

    private class Inner {
        void display() {
            System.out.println("outer outX: " + outX);
        }
    }

}
