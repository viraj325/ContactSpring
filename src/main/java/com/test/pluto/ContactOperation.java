package com.test.pluto;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("")
@Controller
public class ContactOperation {
    List<Contact> contactList = new ArrayList<>();

    @GetMapping("")
    public String intro(ModelMap model){
        model.addAttribute("opening", "Welcome to Custom Contact Directory");
        return "intro";
    }

    @PostMapping("/create")
    @ResponseBody
    public String createContact(@RequestBody Contact contact){
        contactList.add(contact);
        return String.format("New contact created:\nName: %s\nEmail: %s\nPhone:%s\nAddress:%s",
                contact.name, contact.email, contact.phone, contact.address);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllContacts(ModelMap model){
        String response = new Gson().toJson(contactList);
        model.addAttribute("response", response);
        return "contacts";
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public String getSpecificContact(@PathVariable String name, ModelMap model){
        List<Contact> selectedContactList = new ArrayList<>();
        for(Contact contact : contactList){
            if(contact.name.equals(name))
                selectedContactList.add(contact);
        }
        String response = new Gson().toJson(selectedContactList);
        model.addAttribute("response", response);
        return "search";
    }

    @PutMapping("/update/{name}/{phone}")
    public String updateContact(@RequestBody Contact contact, @PathVariable String name, @PathVariable String phone, ModelMap model){
        for(Contact i : contactList){
            if(i.name.equals(name) && i.phone.equals(phone)){
                i.setName(contact.name);
                i.setAddress(contact.address);
                i.setEmail(contact.email);
                i.setPhone(contact.phone);
            }
        }
        model.addAttribute("name", contact.name);
        model.addAttribute("phone", contact.phone);
        model.addAttribute("email", contact.email);
        model.addAttribute("address", contact.address);
        return "update";
    }

    @DeleteMapping("/delete/{name}/{phone}")
    public String deleteSpecificContact(@PathVariable String name, @PathVariable String phone, ModelMap model){
        for(Contact contact : contactList){
            if(contact.name.equals(name) && contact.phone.equals(phone))
                contactList.remove(contact);
        }
        model.addAttribute("name", name);
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