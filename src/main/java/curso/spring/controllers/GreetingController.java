package curso.spring.controllers;

import curso.spring.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    //http:localhost:8080/greeting?name:Hanrry
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam (value = "name", defaultValue = "World")
            String name){
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));

        return greeting;
    }


}
