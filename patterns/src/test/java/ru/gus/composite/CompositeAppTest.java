package ru.gus.composite;

import org.junit.Test;


public class CompositeAppTest {

    @Test
    public void whenSevenNodesAndThreeCompositors() {
        Triangle triangle1 = new Triangle();
        Triangle triangle2 = new Triangle();
        Circle circle1 = new Circle();

        Square square1 = new Square();
        Circle circle2 = new Circle();
        Triangle triangle3 = new Triangle();
        Square square2 = new Square();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComposite(triangle1);
        composite1.addComposite(triangle2);
        composite1.addComposite(circle1);

        composite2.addComposite(square1);
        composite2.addComposite(circle2);
        composite2.addComposite(triangle3);
        composite2.addComposite(square2);

        composite.addComposite(composite1);
        composite.addComposite(composite2);

        composite.draw();

        composite.removeComposite(composite1);
        composite.draw();
    }
}