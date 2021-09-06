package Cookbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookbookController {

    private CookbookRepository cookbookRepository;

    public CookbookController(CookbookRepository cookbookRepository) {
        this.cookbookRepository = cookbookRepository;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
