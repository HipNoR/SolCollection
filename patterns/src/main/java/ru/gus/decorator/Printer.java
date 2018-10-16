package ru.gus.decorator;

/**
 * Класс реализует интерфейс Компонент.
 * Данный класс так же называют ConcreteComponent
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.10.2018
 */
public class Printer implements PrinterInterface {
    private String value;

    public Printer(String value) {
        this.value = value;
    }

    public void print() {
        System.out.print(value);
    }
}
