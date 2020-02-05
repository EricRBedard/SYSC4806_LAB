package com.myApp.model;

import org.springframework.data.annotation.*;

import javax.persistence.*;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private ArrayList<BuddyInfo> buddyInfo;
	
	public AddressBook() {
		this.buddyInfo = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo aBuddyInfo) {
		if (aBuddyInfo != null) {
			this.buddyInfo.add(aBuddyInfo);
		}
	}

    @OneToMany
	public List<BuddyInfo> getBuddyInfo() {
		return buddyInfo;
	}

	public void setBuddyInfo(ArrayList<BuddyInfo> b) { buddyInfo = b;}

	public void removeBuddy(BuddyInfo b) {
		for (int i = 0; i < buddyInfo.size(); i++) {
			if(buddyInfo.get(i).equals(b)) {
                buddyInfo.remove(i);
                break;
			}
		}
	}
	
	public String getBuddyString(int i) {
		return buddyInfo.get(i).toString();
	}

	public String getBuddiesString(){
	    String fullBuddies = "AddressBook:\n";
		for(BuddyInfo buddy: buddyInfo){
            fullBuddies = fullBuddies + buddy.toString() + "\n";
        }
        return fullBuddies;
	}
	
	public BuddyInfo getBuddy(int i) {
		return buddyInfo.get(i);
	}

	public void setId(Long id) {this.id = id;}

	public Long getId(){return id;}
	
	public int size() {
		return buddyInfo.size();
	}

	public void clear() {
        buddyInfo = new ArrayList<BuddyInfo>();
	}

}
