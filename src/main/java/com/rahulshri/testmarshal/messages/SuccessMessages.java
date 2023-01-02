package com.rahulshri.testmarshal.messages;

public class SuccessMessages {

    public enum User{
        USER_DELETED_SUCCESS ("User Deleted Successfully..."),
        USER_CREATED_SUCCESS("User Created Successfully...") ,
        USER_EDITED_SUCCESS("User Edited Successfully...");

        public String value;
        User(String s) {
            this.value=s;
        }
    }
}
