package controllers;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPageController {
    @RequestMapping(value = "/main")
    public String getMainPage(Model model){
        System.out.println("I am in main request method");
        model.addAttribute("name","Bill");
        return "main";
    }

    @RequestMapping(value = "/autho")
    public ModelAndView authorizationPage() {
        return new ModelAndView("authorization", "user", new User());
    }

    @RequestMapping(value = "/pageAfterAuthorization")
    public ModelAndView authorizationPage(@ModelAttribute("user") User user) {
        return new ModelAndView("pageAfterAuthorization", "user", user);
    }


}
