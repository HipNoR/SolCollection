package ru.gus.decorator;

/**
 * Класс декоратор - оборачивает сообщение в кавычки.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.2$
 * @since 0.1
 * 16.10.2018
 */
public class QuotesDecorator extends Decorator {

    public QuotesDecorator(PrinterInterface component) {
      super(component);
    }

    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
