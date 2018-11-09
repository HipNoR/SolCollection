package ru.gus.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite pattern.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 09.11.2018
 */
public class CompositeApp {
}

interface Shape {
    void draw();
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Hi! I am a triangle!");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Hi! I am a square!");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Hi! I am a circle!");
    }
}

class Composite implements Shape {
    private List<Shape> composites = new ArrayList<>();

    public void addComposite(Shape composite) {
        composites.add(composite);
    }

    public void removeComposite(Shape composite) {
        composites.remove(composite);
    }
    @Override
    public void draw() {
        for (Shape shape : composites) {
            shape.draw();
        }
    }
}