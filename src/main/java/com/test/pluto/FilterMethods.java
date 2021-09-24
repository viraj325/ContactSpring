package com.test.pluto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/contacts")
@Controller
public class FilterMethods {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String printHello(ModelMap model){
        model.addAttribute("message", "Hello Spring MVC Framework!");
        model.addAttribute("virajcustom", "This is my custom message");
        return "contacts";
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public String getEmployeesByID(@PathVariable String name, ModelMap model){
        model.addAttribute("inputID", "Name: " + name);
        return "search";
    }
}