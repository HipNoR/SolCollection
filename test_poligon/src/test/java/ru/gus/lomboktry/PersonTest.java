package ru.gus.lomboktry;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PersonTest {

    @Test
    public void whenUseLombokAndGetThanTrue() {
        Person person = new Person("roman", "bedniashov", 34, "crossfit", 1);
        assertThat(person.getFname(), is("roman"));
        assertThat(person.getSname(), is("bedniashov"));
        assertThat(person.getAge(), is(34));
        assertThat(person.getHobby(), is("crossfit"));
        assertThat(person.getId(), is(1));
    }

    @Test
    public void whenSetAndPrintThanTrue() {
        Person person = new Person();
        person.setFname("roman");
        person.setSname("bedniashov");
        person.setAge(34);
        person.setHobby("crossfit");
        person.setId(1);
        assertThat(person.toString(), is("Person(fname=roman, sname=bedniashov, age=34, hobby=crossfit)"));
    }

    @Test
    public void whenBuildViaBuilderThenTrue() {
        Person person = Person.builder()
                .fname("roman")
                .sname("bedniashov")
                .age(34)
                .hobby("crossfit")
                .build();
        assertThat(person.toString(), is("Person(fname=roman, sname=bedniashov, age=34, hobby=crossfit)"));
    }
}