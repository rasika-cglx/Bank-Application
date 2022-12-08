package com.cog.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*Initially, we will create a simple Spring Boot web application and slowly move forward to add more functionality such as API, Persistence, etc.

		To Start with
		Create a Spring Boot project with required dependencies such as
		Spring Web
		Lombok
		Spring Boot Dev Tools
		Build a simple system that supports
		Bank Account
		Bank operations such as deposit and withdraw
		A banking system must consist of a customer and a bank account to allow the required operation.
		Build the unit test cases for the basic operations.
		Commit the project to the git repository and set up a proper .gitignore file.
*/

@SpringBootApplication
public class BankAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankAppApplication.class, args);
    }

}
