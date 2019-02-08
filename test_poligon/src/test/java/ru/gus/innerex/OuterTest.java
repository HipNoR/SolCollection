package ru.gus.innerex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OuterTest {

    @Test
    public void innerDemo() {
        Outer outer = new Outer();
        outer.test();
    }


}