package ru.gus.dispatch;

public interface Person {

    int age();

    enum Access {
        FORBIDDEN,
        LIMIT,
        FREE
    }
}
