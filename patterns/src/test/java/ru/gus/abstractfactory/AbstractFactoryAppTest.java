package ru.gus.abstractfactory;

import org.junit.Test;


public class AbstractFactoryAppTest {

    @Test
    public void whenCreatesRuFactory() {
        AbstractFactoryApp app = new AbstractFactoryApp();
        AbstractFactoryApp.DeviceFactory factory = app.getFactoryByCode("RU");
        AbstractFactoryApp.Keyboard k = factory.getKeyboard();
        AbstractFactoryApp.Mouse m = factory.getMouse();
        AbstractFactoryApp.Touchpad t = factory.getTouchpad();

        k.print();
        m.dbclick();
        m.scroll(1);
        t.track(10, 5);
    }

    @Test
    public void whenCreatesEnFactory() {
        AbstractFactoryApp app = new AbstractFactoryApp();
        AbstractFactoryApp.DeviceFactory factory = app.getFactoryByCode("EN");
        AbstractFactoryApp.Keyboard k = factory.getKeyboard();
        AbstractFactoryApp.Mouse m = factory.getMouse();
        AbstractFactoryApp.Touchpad t = factory.getTouchpad();

        k.println();
        m.click();
        m.scroll(1);
        t.track(10, 5);
    }

    @Test (expected = RuntimeException.class)
    public void whenWrongCodeThanException() {
        AbstractFactoryApp app = new AbstractFactoryApp();
        AbstractFactoryApp.DeviceFactory factory = app.getFactoryByCode("US");
    }
}