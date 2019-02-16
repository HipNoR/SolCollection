package ru.hipnor.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.hipnor.ws.HelloWebService;
import ru.hipnor.ws.HelloWebServiceImpl;

// классы, чтобы пропарсить xml-ку c wsdl описанием
// и дотянуться до тега service в нем
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import java.net.MalformedURLException;
//для получения WDSL описания и через него достичь сервиса
import java.net.URL;

/**
 * Передача стринга туда сюда в веб сервис и возврат обработанного значения.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.02.2019
 */
public class HelloWebServiceClient {
    private static final Logger LOG = LogManager.getLogger(HelloWebServiceClient.class.getName());

    public static void main(String[] args) throws MalformedURLException {

        //ссылка на wdsl описание
        URL url = new URL("http://localhost:1986/wss/hello?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qName = new QName("http://ws.hipnor.ru/", "HelloWebServiceImplService");

        //теперь можно дотянуться до тега Service в wdsl описании
        Service service = Service.create(url, qName);

        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        HelloWebService hello = service.getPort(HelloWebService.class);

        // Теперь можно вызывать удаленный метод
        System.out.println(hello.getHelloString("HipNo"));
    }

}
