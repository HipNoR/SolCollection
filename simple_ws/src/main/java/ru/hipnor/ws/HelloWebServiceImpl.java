package ru.hipnor.ws;

import javax.jws.WebService;

/**
 * Сервис принимает стринг и возвращает дополненный. просто пример.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version $
 * @since 0.1
 * 15.02.2019
 */
//используется с параметром указывающим полное имя нашего класса веб-сервиса
@WebService(endpointInterface = "ru.hipnor.ws.HelloWebService")
public class HelloWebServiceImpl implements HelloWebService {

    @Override
    public String getHelloString(String name) {
        return "Hello, " + name + "!";
    }

}
