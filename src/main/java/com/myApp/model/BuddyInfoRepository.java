package com.myApp.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByName(String name);
    List<BuddyInfo> findByAddress(String address);
    List<BuddyInfo> findByPhoneNumber(int phoneNumber);
    BuddyInfo findById(long id);
    void deleteById(Long id);
}
