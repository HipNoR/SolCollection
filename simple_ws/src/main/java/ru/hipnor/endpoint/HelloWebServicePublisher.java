package ru.hipnor.endpoint;

import javax.xml.ws.Endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.hipnor.ws.HelloWebServiceImpl;
import ru.hipnor.ws.StorageWebServiceImpl;


/**
 * Публикатор ендпоинтов.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 15.02.2019
 */
public class HelloWebServicePublisher {
    private static final Logger LOG = LogManager.getLogger(HelloWebServicePublisher.class.getName());

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:1986/wss/hello", new HelloWebServiceImpl());
        Endpoint.publish("http://localhost:1986/wss/storage", new StorageWebServiceImpl());
    }

}
