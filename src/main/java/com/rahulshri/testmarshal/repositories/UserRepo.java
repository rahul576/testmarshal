package com.rahulshri.testmarshal.repositories;

import com.rahulshri.testmarshal.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Long> {

}
