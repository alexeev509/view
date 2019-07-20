package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {
    @RequestMapping(value = "/main")
    public String getMainPage(Model model){
        System.out.println("I am in main request method");
        model.addAttribute("name","Bill");
        return "main";
    }
}
