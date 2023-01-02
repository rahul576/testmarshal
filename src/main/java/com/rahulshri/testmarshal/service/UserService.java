package com.rahulshri.testmarshal.service;

import com.rahulshri.testmarshal.entities.Users;
import com.rahulshri.testmarshal.messages.ErrorHandling;
import com.rahulshri.testmarshal.messages.ErrorMessages;
import com.rahulshri.testmarshal.modal.UserDetail;
import com.rahulshri.testmarshal.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public Users save(UserDetail userDetail) throws ErrorHandling{
        try{
        Users users = new Users(userDetail);
        userRepo.save(users);
        return users;
        }catch (Exception e){
            log.error("Error while adding the user{}, Error is :{}", userDetail.toString(), e.getMessage(), e);
            throw new ErrorHandling(HttpStatus.OK,ErrorMessages.USET_CREATE_ERROR,e);
        }

    }


    public ArrayList<UserDetail> getAllUsers() throws Exception{
        ArrayList<UserDetail> listUserDetail = new ArrayList<>();
        ArrayList<Users> listUsers = (ArrayList<Users>) userRepo.findAll();
        if(listUsers.isEmpty())
            throw new Exception("Could not find any user in the Database");
        for(Users user : listUsers){
            listUserDetail.add(new UserDetail(user.getId(),user.getName(),user.getEmail()));
        }
        return listUserDetail;
    }

    public UserDetail getUser(Long userId) throws Exception{
        Optional<Users> user = userRepo.findById(userId);
        if(user.isPresent())
            return new UserDetail(user.get().getId(),user.get().getName(),user.get().getEmail());
        else
            throw new Exception("Could not find user in DB");
    }

    public void delete(Long userId) throws ErrorHandling {
        try{
            userRepo.deleteById(userId);
        }catch (Exception e){
            log.error("Could not delete user with id{} due to Error ",userId,e.getMessage(),e);
            throw new ErrorHandling(HttpStatus.OK,ErrorMessages.USER_DELETE_ERROR,e);
        }
    }
}
