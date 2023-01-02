package com.rahulshri.testmarshal.controller;

import com.rahulshri.testmarshal.entities.Users;
import com.rahulshri.testmarshal.messages.ErrorHandling;
import com.rahulshri.testmarshal.messages.SuccessMessages;
import com.rahulshri.testmarshal.modal.ApiResponse;
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
@RequestMapping(value = "v1/user", produces = {"application/json"})
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addUser(@RequestBody UserDetail userDetail) {
        try {
            Users user = userService.save(userDetail);
            return new ResponseEntity<>(new ApiResponse(SuccessMessages.User.USER_CREATED_SUCCESS.value, ApiResponse.ResponseCodes.SUCCESS), HttpStatus.CREATED);
        } catch (ErrorHandling e) {
             return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllUsers() throws Exception {
        ArrayList<UserDetail> listUserDetail = userService.getAllUsers();
        return new ResponseEntity<>(listUserDetail, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUserByID(@PathVariable("id") Long userId) throws Exception {
        UserDetail userDetail = userService.getUser(userId);
        return new ResponseEntity<>(userDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Long userId) {
        try {
            userService.delete(userId);
            return new ResponseEntity<>(new ApiResponse(SuccessMessages.User.USER_DELETED_SUCCESS.value, ApiResponse.ResponseCodes.SUCCESS),HttpStatus.OK);
        } catch (ErrorHandling e) {
            return new ResponseEntity<>(new ApiResponse(e.errorMessage, ApiResponse.ResponseCodes.FAILED),HttpStatus.OK);
        }
    }


}
