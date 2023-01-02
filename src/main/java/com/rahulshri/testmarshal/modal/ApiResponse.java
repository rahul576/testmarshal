package com.rahulshri.testmarshal.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiResponse {
    String message;
    ResponseCodes responseCode;
     public enum ResponseCodes{
        SUCCESS, FAILED
    }

    public ApiResponse(String message,ResponseCodes responseCode){
         this.message=message;
         this.responseCode=responseCode;
    }
}
