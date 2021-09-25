package com.test.pluto;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("")
@Controller
public class HelloWeb {
    List<Contact> contactList = new ArrayList<>();

    @GetMapping("/")
    public String intro(ModelMap model){
        model.addAttribute("opening", "Welcome to Custom Contact Directory");
        return "intro";
    }

    //@PostMapping("/create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createContact(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String address){
        contactList.add(new Contact(name, email, phone, address));
        return String.format("New contact created:\nName: %s\nEmail: %s\nPhone:%s\nAddress:%s",
                name, email, phone, address);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView getAllContacts(){
        ModelAndView map = new ModelAndView("contacts");
        map.addObject("response", contactList);
        return map;
    }

    @RequestMapping(value = "/search/{phone}", method = RequestMethod.GET)
    public String getSpecificContact(@PathVariable String phone, ModelMap model){
        List<Contact> selectedContactList = new ArrayList<>();
        for(Contact contact : contactList){
            if(contact.phone.equals(phone))
                selectedContactList.add(contact);
        }
        String response = new Gson().toJson(selectedContactList);
        model.addAttribute("response", response);
        return "search";
    }

    //@PutMapping("/update/{initialName}/{initialPhone}")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateContact(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String address, @RequestParam String initialPhone, ModelMap model){
        for(Contact i : contactList){
            if(i.phone.equals(initialPhone)){
                i.setName(name);
                i.setAddress(address);
                i.setEmail(email);
                i.setPhone(phone);
            }
        }
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        model.addAttribute("email", email);
        model.addAttribute("address", address);
        return "update";
    }

    //@DeleteMapping("/delete/{name}/{phone}")
    @RequestMapping(value = "/delete/{phone}", method = RequestMethod.DELETE)
    public String deleteSpecificContact(@PathVariable String phone, ModelMap model){
        for(Contact contact : contactList){
            if(contact.phone.equals(phone))
                contactList.remove(contact);
        }
        model.addAttribute("phone", phone);
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAllContacts(){
        contactList.clear();
        return "All of the contacts are deleted!";
    }
}