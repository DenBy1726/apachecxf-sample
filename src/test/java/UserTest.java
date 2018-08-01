import com.example.entity.User;
import com.example.entity.UserImpl;
import com.example.service.HelloWorld;
import com.example.service.HelloWorldImpl;
import org.junit.Before;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class UserTest {
    private static QName SERVICE_NAME
            = new QName("http://introduction.cxf.baeldung.com/", "helloWorld");
    private static QName PORT_NAME
            = new QName("http://introduction.cxf.baeldung.com/", "helloWorldPort");

    private Service service;
    private HelloWorld baeldungProxy;
    private HelloWorldImpl baeldungImpl;

    {
        service = Service.create(SERVICE_NAME);
        String endpointAddress = "http://localhost:8080/helloWorld";
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
    }

    @Before
    public void reinstantiate() {
        baeldungImpl = new HelloWorldImpl();
        baeldungProxy = service.getPort(PORT_NAME, HelloWorld.class);
    }

    @Test
    public void whenUsingHelloMethod_thenCorrect() {
        String endpointResponse = baeldungProxy.hello("Baeldung");
        String localResponse = baeldungImpl.hello("Baeldung");
        assertEquals(localResponse, endpointResponse);
    }

    @Test
    public void whenUsingHelloUserMethod_thenCorrect() {
        User student = new UserImpl("John Doe");
        String endpointResponse = baeldungProxy.helloUser(student);
        String localResponse = baeldungImpl.helloUser(student);
        assertEquals(localResponse, endpointResponse);
    }

    @Test
    public void usingGetUsersMethod_thenCorrect() {
        User user1 = new UserImpl("Adam");
        baeldungProxy.helloUser(user1);

        User user2 = new UserImpl("Eve");
        baeldungProxy.helloUser(user2);

        Map<Integer, User> students = baeldungProxy.getUsers();
        assertEquals("Adam", students.get(1).getName());
        assertEquals("Eve", students.get(2).getName());
    }
}