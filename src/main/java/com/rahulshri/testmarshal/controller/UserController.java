package com.rahulshri.testmarshal.controller;

import com.rahulshri.testmarshal.entities.Users;
import com.rahulshri.testmarshal.modal.UserDetail;
import com.rahulshri.testmarshal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping(value = "v1/user",produces = {"application/json"})
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addUser(@RequestBody UserDetail userDetail){
        try {
            userService.isValidUser(userDetail);
            Users user = userService.save(userDetail);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Error while adding the user{}, Error is :{}", userDetail.toString(),e.getMessage(),e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllUsers(){
        ArrayList<UserDetail> listUserDetail = userService.getAllUsers();
        return new ResponseEntity<>(listUserDetail,HttpStatus.ACCEPTED);
    }

}
