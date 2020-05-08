package felipe.huff.databasetrabalho.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String index() {return "Bem vindo Hello World";}
}
