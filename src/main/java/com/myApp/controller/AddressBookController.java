package com.myApp.controller;

import com.myApp.model.AddressBook;
import com.myApp.model.BuddyInfo;
import com.myApp.model.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    @Autowired
    BuddyInfoRepository repository;

    @PutMapping("/deleteAll")
    public void CreateAddressBook(){
        repository.deleteAll();
    }

    @GetMapping("/delete")
    public String removeBuddy(@RequestParam("id")Long id, Model model){
        BuddyInfo bud = repository.findById(id).orElse(null);
        String name = null;
        if(bud != null){
            name = bud.getName();
        }
        repository.deleteById(id);
        model.addAttribute("name", name);
        return "delete";
   }

    @PostMapping("/create")
    public String addBuddy(@ModelAttribute BuddyInfo buddyInfo, Model model){
        repository.save(buddyInfo);
        return "result";
    }

    @GetMapping("/create")
    public String add(Model model){
        model.addAttribute("buddy", new BuddyInfo());
        return "create";
    }

    @GetMapping("/get")
    @ResponseBody
    public AddressBook listBuddyInfo(){
        Iterable<BuddyInfo> buddies = repository.findAll();
        AddressBook address = new AddressBook();
        for(BuddyInfo buddy : buddies){
            address.addBuddy(buddy);
        }
        // model.addAttribute(address.getBuddiesString(), buddies);
        return address;
    }
}
