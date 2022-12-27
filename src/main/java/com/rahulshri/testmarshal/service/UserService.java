package com.rahulshri.testmarshal.service;

import com.rahulshri.testmarshal.entities.Users;
import com.rahulshri.testmarshal.modal.UserDetail;
import com.rahulshri.testmarshal.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Users save(UserDetail userDetail){
        Users users = new Users(userDetail);
        userRepo.save(users);
        return users;
    }
    public void isValidUser(UserDetail userDetail) throws Exception{
        if(userDetail.getName()==null){
            throw (new Exception("user name should not be null"));
        }
    }

    public ArrayList<UserDetail> getAllUsers(){
        ArrayList<UserDetail> listUserDetail = new ArrayList<>();
        ArrayList<Users> listUsers = (ArrayList<Users>) userRepo.findAll();
        for(Users user : listUsers){
            listUserDetail.add(new UserDetail(user.getName(),user.getEmail()));
        }
        return listUserDetail;
    }
}
