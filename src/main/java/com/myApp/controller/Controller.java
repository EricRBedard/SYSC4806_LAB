package com.myApp.controller;

import com.myApp.model.AddressBook;
import com.myApp.model.BuddyInfo;
import com.myApp.model.BuddyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Controller {
    private AddressBook address;
    private BuddyInfoRepository repository;

    @Autowired
    public Controller(BuddyInfoRepository repo){
        this.address = new AddressBook();
        repository = repo;
    }

    public void addBuddy(String name, String address, int number) {
        BuddyInfo info = new BuddyInfo(name, address, number);
        this.address.addBuddy(info);
        repository.save(info);
        System.out.println("com.myApp.model.BuddyInfo saved: " + repository.findByName(name).toString());
    }
}
