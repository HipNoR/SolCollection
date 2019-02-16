package ru.hipnor.ws;

import ru.hipnor.persistent.Storage;
import ru.hipnor.persistent.StorageMemoryImpl;

import javax.jws.WebService;
import java.util.ArrayList;

/**
 * Вебсервис хранилище.
 * //TODO реализовать сериализацию листа для передачи клиенту.
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version $
 * @since 0.1
 * 16.02.2019
 */
//используется с параметром указывающим полное имя нашего класса веб-сервиса
@WebService(endpointInterface = "ru.hipnor.ws.StorageWebService")
public class StorageWebServiceImpl implements StorageWebService {

    private final Storage<String> storage = new StorageMemoryImpl<>();

    @Override
    public void addElement(String element) {
        this.storage.addElement(element);
    }

    @Override
    public ArrayList<String> getElements() {
        return this.storage.getElements();
    }
}
