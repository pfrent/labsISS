import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

public class StartServer {
    //private static int defaultPort=55555;
    public static void main(String[] args) {

        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:spring-server.xml");
    }

}
