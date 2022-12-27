package com.rahulshri.testmarshal.entities;

import com.rahulshri.testmarshal.modal.UserDetail;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users",uniqueConstraints = @UniqueConstraint(
        name = "emailId_unique",
        columnNames = "email"
))
public class Users {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,generator = "user_seq"
    )
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    public Users(UserDetail userDetail){
        this.name=userDetail.getName();
        this.email=userDetail.getEmail();
    }

}
