package ru.gus.builder;

import org.junit.Test;


public class BuilderAppTest {

    @Test
    public void whenMondeo() {
        Director dir = new Director();
        dir.setBuilder(new FordMondeoBuilder());
        Auto auto = dir.buildCar();
        System.out.println(auto);
    }

    @Test
    public void whenSubaru() {
        Director dir = new Director();
        dir.setBuilder(new SubaruBuilder());
        Auto auto = dir.buildCar();
        System.out.println(auto);
    }
}