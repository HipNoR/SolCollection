package ru.gus.generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatsTest {

    @Test
    public void name() {
        Integer[] inI = {1, 2, 3, 4};
        Stats<Integer> statsI = new Stats<>(inI);
        System.out.println(statsI.average());

        Double[] inD = {1.1, 2.2, 3.3, 4.4};
        Stats<Double> statsD = new Stats<>(inD);
        System.out.println(statsD.average());

        Float[] inF = {1.0F, 2.0F, 3.0F, 4.0F};
        Stats<Float> statsF = new Stats<>(inF);
        System.out.println(statsF.average());

        System.out.println(statsI.sameAvg(statsD));
        System.out.println(statsI.sameAvg(statsF));

    }
}