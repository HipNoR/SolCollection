package ru.gus.delagate;

/**
 * Delegate class.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 18.10.2018
 */
public class Painter {
    private Graphics graphics;

    public void setGraphics(Graphics g) {
        this.graphics = g;
    }

    public void draw() {
        graphics.draw();
    }
}
