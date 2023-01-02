package com.rahulshri.testmarshal.modal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Builder
@Data
@AllArgsConstructor
public class UserDetail {
    private Long id;
    private String name;
    private String email;
}
