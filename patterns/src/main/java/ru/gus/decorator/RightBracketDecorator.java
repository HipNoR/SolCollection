package ru.gus.decorator;

/**
 * Класс декоратор - ставит в сообщение правую скобку.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.10.2018
 */
public class RightBracketDecorator implements PrinterInterface {
    PrinterInterface component;

    public RightBracketDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}
