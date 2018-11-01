package ru.gus.abstractfactory;

/**
 * Abstract factory pattern.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 01.11.2018
 */
public class AbstractFactoryApp {

    interface Mouse {
        void click();
        void dbclick();
        void scroll(int direction);
    }

    interface Keyboard {
        void print();
        void println();
    }

    interface Touchpad {
        void track(int deltaX, int deltaY);
    }

    interface DeviceFactory {
        Mouse getMouse();
        Keyboard getKeyboard();
        Touchpad getTouchpad();
    }

    class RuMouse implements Mouse {

        @Override
        public void click() {
            System.out.println("Щелчок мышью");
        }

        @Override
        public void dbclick() {
            System.out.println("Двойной щелчок мышью");
        }

        @Override
        public void scroll(int direction) {
            if (direction > 0) {
                System.out.println("Скролим вверх");
            } else if (direction < 0) {
                System.out.println("Скролим вниз");
            } else {
                System.out.println("Не скролим");
            }
        }
    }

    class RuKeyboard implements Keyboard {

        @Override
        public void print() {
            System.out.println("Печатаем строку");
        }

        @Override
        public void println() {
            System.out.println("Печатаем строку с переводом строки");
        }
    }

    class RuTouchpad implements Touchpad {

        @Override
        public void track(int deltaX, int deltaY) {
            int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
            System.out.println(String.format("Передвинулись на %s пикселей", s));
        }
    }

    class EnMouse implements Mouse {

        @Override
        public void click() {
            System.out.println("Mouse click");
        }

        @Override
        public void dbclick() {
            System.out.println("Double mouse click");
        }

        @Override
        public void scroll(int direction) {
            if (direction > 0) {
                System.out.println("Scroll up");
            } else if (direction < 0) {
                System.out.println("Scroll down");
            } else {
                System.out.println("Not scroll");
            }
        }
    }

    class EnKeyboard implements Keyboard {

        @Override
        public void print() {
            System.out.println("Print");
        }

        @Override
        public void println() {
            System.out.println("Println");
        }
    }

    class EnTouchpad implements Touchpad {

        @Override
        public void track(int deltaX, int deltaY) {
            int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
            System.out.println(String.format("Moved by %s pixels", s));
        }
    }

    class RuDeviceFactory implements DeviceFactory {

        @Override
        public Mouse getMouse() {
           return new RuMouse();
        }

        @Override
        public Keyboard getKeyboard() {
            return new RuKeyboard();
        }

        @Override
        public Touchpad getTouchpad() {
            return new RuTouchpad();
        }
    }

    class EnDeviceFactory implements DeviceFactory {

        @Override
        public Mouse getMouse() {
            return new EnMouse();
        }

        @Override
        public Keyboard getKeyboard() {
            return new EnKeyboard();
        }

        @Override
        public Touchpad getTouchpad() {
            return new EnTouchpad();
        }
    }

    public DeviceFactory getFactoryByCode(String code) {
        DeviceFactory factory;
        if (code.equals("RU")) {
            factory = new RuDeviceFactory();
        } else if (code.equals("EN")) {
            factory = new EnDeviceFactory();
        } else {
            throw new RuntimeException("Unsupported Country Code " + code);
        }
        return factory;
    }
}
