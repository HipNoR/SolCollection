package ru.gus.builder;

/**
 * Builder pattern with director.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 07.11.2018
 */
public class BuilderApp {
}

enum Transmissions {
    MANUAL, AUTO
}

class Auto {
    private String make;
    private Transmissions transmissions;
    private int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }
    public void setTransmission(Transmissions transmissions) {
        this.transmissions = transmissions;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("Auto{make = %s, transmission = %s, maxSpeed = %s}", make, transmissions, maxSpeed);
    }
}

abstract class AutoBuilder {
    Auto auto;

    void createAuto() {
        auto = new Auto();
    }

    abstract public void buildMake();
    abstract public void buildTransmission();
    abstract public void buildMaxSpeed();

    public Auto getAuto() {
        return auto;
    }
}

class FordMondeoBuilder extends AutoBuilder {

    @Override
    public void buildMake() {
        auto.setMake("Ford Mondeo");
    }
    @Override
    public void buildTransmission() {
        auto.setTransmission(Transmissions.AUTO);
    }

    @Override
    public void buildMaxSpeed() {
        auto.setMaxSpeed(290);
    }
}

class SubaruBuilder extends AutoBuilder {

    @Override
    public void buildMake() {
        auto.setMake("Subaru");
    }
    @Override
    public void buildTransmission() {
        auto.setTransmission(Transmissions.MANUAL);
    }

    @Override
    public void buildMaxSpeed() {
        auto.setMaxSpeed(320);
    }
}

class Director {
    AutoBuilder builder;

    public void setBuilder(AutoBuilder builder) {
        this.builder = builder;
    }

    public Auto buildCar() {
        builder.createAuto();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        return builder.getAuto();
    }
}

