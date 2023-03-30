package net.lectures.springboot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*@Controller
@ResponseBody //Bu Java objesinin Json formatına dönüşmesi için kullandığımız bir annotation.*/

@RestController //Yukarıdaki ikisini aynı anda annotate ediyor.
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

}
