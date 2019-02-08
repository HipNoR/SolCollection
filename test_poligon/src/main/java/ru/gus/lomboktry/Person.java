package ru.gus.lomboktry;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Класс использует библиотеку lombok.
 * При компиляции автоматически создает геттеры и сеттеры, методы equals, hashcode и toString.
 * С помощью аннотаций @NoArgsConstructor создает коструктор без аргументов, @AllArgsConstructor
 * создает конструктор со всеми аргументами. Для работы необходимо подключить плагин в среде.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 08.02.2019
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String fname;
    private String sname;
    private int age;
    private String hobby;
}
