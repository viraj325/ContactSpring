package com.test.pluto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.Iterator;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String createContact(@RequestParam String name, @RequestParam String email, @RequestParam String phone, @RequestParam String address){
        contactList.add(new Contact(name, email, phone, address));
        return String.format("New contact created:\nName: %s\nEmail: %s\nPhone: %s\nAddress: %s",
                name, email, phone, address);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView getAllContacts(){
        ModelAndView map = new ModelAndView("contacts");
        map.addObject("title", "All Contacts");
        map.addObject("response", contactList);
        return map;
    }

    @RequestMapping(value = "/search/{phone}", method = RequestMethod.GET)
    public ModelAndView getSpecificContact(@PathVariable String phone){
        ModelAndView map = new ModelAndView("contacts");
        List<Contact> selectedList = new ArrayList<>();
        for(Contact contact : contactList){
            if(contact.phone.equals(phone))
                selectedList.add(contact);
        }
        map.addObject("title", String.format("Searched: %s", phone));
        map.addObject("response", selectedList);
        return map;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateContact(@RequestParam String name, @RequestParam String email, @RequestParam String phone,
                                @RequestParam String address, @RequestParam String initialPhone){
        for(Contact i : contactList){
            if(i.phone.equals(initialPhone)){
                i.setName(name);
                i.setAddress(address);
                i.setEmail(email);
                i.setPhone(phone);
            }
        }
        return String.format("Contact updated:\nName: %s\nEmail: %s\nPhone: %s\nAddress: %s",
                name, email, phone, address);
    }

    @RequestMapping(value = "/delete/{phone}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSpecificContact(@PathVariable String phone){
        for (Iterator<Contact> iterator = contactList.iterator(); iterator.hasNext(); ) {
            Contact value = iterator.next();
            if (value.phone.equals(phone))
                iterator.remove();
        }
        return String.format("Contact Deleted with Phone: %s", phone);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteAllContacts(){
        contactList.clear();
        return "All of the contacts are deleted!";
    }
}