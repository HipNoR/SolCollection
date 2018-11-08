package ru.gus.prototype;

/**
 * prototype pattern.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 08.11.2018
 */
public class PrototypeApp {
}

interface Copyable {
    Object copy();
}

class Human implements Copyable {
    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Human: age=" + age + ", name=" + name;
    }

    @Override
    public Object copy() {
       return new Human(this.age, this.name);
    }
}

class HumanFactory {
    private Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }

    public void setPrototype(Human human) {
        this.human = human;
    }

    public Human getCopy() {
        return (Human) human.copy();
    }
}