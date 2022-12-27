package com.rahulshri.testmarshal;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class TestmarshalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestmarshalApplication.class, args);
	}

}
