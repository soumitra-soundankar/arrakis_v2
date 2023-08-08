package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class UserInitializer implements CommandLineRunner {

    private final UsersRepository usersRepository;
    private static final int NUMBER_OF_SAMPLES = 50;

    @Autowired
    public UserInitializer(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        //Insert sample data into the Users table
        // Users user1 = new Users("John Doe", "john.doe@example.com", "ROLE_USER");
        // usersRepository.save(user1);

        // Users user2 = new Users("Jane Smith", "jane.smith@example.com", "ROLE_ADMIN");
        // usersRepository.save(user2);

        String fileName ="src/main/java/com/db/grad/javaapi/model/data/users.txt"; // Name of the text file containing the dataset

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                
                String[] userData = line.split(", ");
                if (userData.length == 3) {
                    String name = userData[0];
                    String email = userData[1];
                    String role = userData[2];

                    // Assuming you have a Users class with appropriate constructor
                    Users user = new Users(name, email, role);

                    // Assuming you have a UsersRepository interface extending JpaRepository
                    usersRepository.save(user);
                } else {
                    System.err.println("Invalid data format in the dataset: " + line);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
       
    }

    
}
