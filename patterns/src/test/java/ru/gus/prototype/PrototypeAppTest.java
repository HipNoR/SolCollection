package ru.gus.prototype;

import org.junit.Test;


public class PrototypeAppTest {

    @Test
    public void whenAddThreeCopies() {
        Human original = new Human(18, "Oleg");
        HumanFactory factory = new HumanFactory(original);
        Human copyOne = factory.getCopy();
        Human copyTwo = factory.getCopy();
        Human copyThree = factory.getCopy();
        System.out.println(copyOne);
        System.out.println(copyTwo);
        System.out.println(copyThree);
    }
}