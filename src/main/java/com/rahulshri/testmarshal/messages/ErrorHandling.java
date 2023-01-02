package com.rahulshri.testmarshal.messages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@JsonIgnoreProperties(value = {"message","stackTrace","suppressed","localizedMessage"})
public class ErrorHandling extends RuntimeException {

    public HttpStatus errorCode;
    public String errorMessage;
    public Throwable cause;
    public ErrorHandling(HttpStatus errorCode, String errorMessage, Throwable cause) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.cause = cause;
    }

    @Override

    public String toString() {
        return "ErrorHandling{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", cause=" + cause +
                '}';
    }
}
