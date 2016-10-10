package in.co.codenation.ws;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@RestController
public class GreetingMicroserviceApplication {

    private static String message;
    private static final Logger logger = Logger.getLogger(GreetingMicroserviceApplication.class);

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the greet message: ");
            message = br.readLine();
        }
        SpringApplication.run(GreetingMicroserviceApplication.class, args);
    }

    @RequestMapping("/")
    GreetModel greet() {
    	logger.info("Requested /");
        return new GreetModel(message);
    }

    @RequestMapping("/greet/{name}")
    GreetModel greetPerson(@PathVariable("name") String name) {
        return new GreetModel(String.format("%s %s", message, name));
    }
}
