package ru.gus.dispatch;

public interface Action {

    Type type();

    enum Type {
        ADD,
        UPDATE,
        DELETE
    }
}
