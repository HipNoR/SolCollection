package ru.hipnor.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * //TODO comment
 *
 * @author Roman Bednyashov (hipnorosva@gmail.com)
 * @version 0.1$
 * @since 0.1
 * 16.02.2019
 */

//указывает, что наш интерфейс будет работать как веб сервис
@WebService
//указывает, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StorageWebService {
    //указывает, что метод можно вызвать удаленно
    @WebMethod
    void addElement(String element);

    @WebMethod
    ArrayList<String> getElements();
}
