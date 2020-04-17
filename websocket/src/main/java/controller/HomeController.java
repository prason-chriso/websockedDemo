package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping("/first")
    public  String getPage() {
        return "home";
    }


    @RequestMapping("/")
    public  String getpg() {
        return "dashboard";
    }
}
