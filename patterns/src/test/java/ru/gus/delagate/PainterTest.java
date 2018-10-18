package ru.gus.delagate;

import org.junit.Test;


public class PainterTest {

    @Test
    public void whenPainterDrawsAllGraphicsThenTrue() {
        Painter painter = new Painter();
        painter.setGraphics(new Triangle());
        painter.draw();

        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();
    }
}