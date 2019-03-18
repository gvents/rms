package ge.edu.tsu;

import ch.qos.logback.classic.BasicConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

/**
 * Created by IntelliJ IDEA.
 * User: gvanca
 * Date: 3/18/2019
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8084"));
        app.run(args);
        //SpringApplication.run(Application.class, args);
    }
}
