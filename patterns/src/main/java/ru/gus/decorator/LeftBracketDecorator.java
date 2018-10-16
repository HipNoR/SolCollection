package ru.gus.decorator;

/**
 * Класс декоратор - ставит в сообщение левую скобку.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.10.2018
 */
public class LeftBracketDecorator implements PrinterInterface {
    PrinterInterface component;

    public LeftBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}
