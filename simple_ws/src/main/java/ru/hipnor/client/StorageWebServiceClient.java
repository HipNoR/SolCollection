package ru.hipnor.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.hipnor.ws.StorageWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Передача сообщений в хранилище и прием коллекции хранилища.
 * ЧТо бы заработало нужно настроить маршаллинг и анмаршаллинг списка.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.02.2019
 */
public class StorageWebServiceClient {
    private static final Logger LOG = LogManager.getLogger(StorageWebServiceClient.class.getName());

    public static void main(String[] args) throws MalformedURLException {

        //ссылка на wdsl описание
        URL url = new URL("http://localhost:1986/wss/storage?wsdl");

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qName = new QName("http://ws.hipnor.ru/", "StorageWebServiceImplService");

        //теперь можно дотянуться до тега Service в wdsl описании
        Service service = Service.create(url, qName);

        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
        StorageWebService hello = service.getPort(StorageWebService.class);

        hello.addElement("first");
        hello.addElement("second");
        List<String> storage = hello.getElements();
        System.out.println(storage);
    }

}
