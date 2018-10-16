package ru.gus.decorator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PrinterTest {

    // поле ссылки на стандартный вывод в консоль
    private final PrintStream stdout = System.out;
    // Поле - буфер для хранения данных вывода
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    // Метод реализует замену стандартного вывода в консоль на вывод в память.
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    //Метод реализует обратный выход в консоль
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenSendMessageThenPrint() {
        PrinterInterface printer = new Printer("Hello!");
        printer.print();
        String expected = "Hello!";
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenSendMessageThenPrintQuotes() {
        PrinterInterface printer = new QuotesDecorator(new Printer("Hello!"));
        printer.print();
        String expected = "\"Hello!\"";
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenSendMessageThenPrintLeftBracket() {
        PrinterInterface printer = new LeftBracketDecorator(new Printer("Hello!"));
        printer.print();
        String expected = "[Hello!";
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenSendMessageThenPrintRightBracket() {
        PrinterInterface printer = new RightBracketDecorator(new Printer("Hello!"));
        printer.print();
        String expected = "Hello!]";
        assertThat(new String(out.toByteArray()), is(expected));
    }

    @Test
    public void whenMultiplyDecoratorWhenPrintFullDecoratorMessage() {
        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello!"))));
        printer.print();
        String expected = "\"[Hello!]\"";
        assertThat(new String(out.toByteArray()), is(expected));
    }
}