package ru.gus.builder;

import org.junit.Test;


public class SimpleBuilderAppTest {

    @Test
    public void whenDefault() {
        Car car = new CarBuilder().build();
        System.out.println(car);
    }

    @Test
    public void whenNotDefault() {
        Car car = new CarBuilder()
                .buildMake("Honda")
                .buildTransmission(Transmission.AUTO)
                .buildMaxSpeed(200)
                .build();
        System.out.println(car);
    }
}