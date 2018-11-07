package ru.gus.builder;

/**
 * Simple builder.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 07.11.2018
 */
public class SimpleBuilderApp {
}

enum Transmission {
    MANUAL, AUTO
}

class Car {
    private String make;
    private Transmission transmission;
    private int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("Car {make = %s, transmission = %s, maxSpeed = %s}", make, transmission, maxSpeed);
    }
}

class CarBuilder {
    private String m = "Default";
    private Transmission t = Transmission.MANUAL;
    private int s = 120;

    public CarBuilder buildMake(String m) {
        this.m = m;
        return this;
    }

    public CarBuilder buildTransmission(Transmission t) {
        this.t = t;
        return this;
    }

    public CarBuilder buildMaxSpeed(int s) {
        this.s = s;
        return this;
    }

    public Car build() {
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}
