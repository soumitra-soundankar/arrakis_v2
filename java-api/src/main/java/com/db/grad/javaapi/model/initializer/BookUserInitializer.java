package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import com.db.grad.javaapi.model.Users;
import com.db.grad.javaapi.repository.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Component
public class BookUserInitializer implements CommandLineRunner {

    private final BookUserRepository bookUserRepository;

    @Autowired
    public BookUserInitializer(BookUserRepository bookUserRepository) {
        this.bookUserRepository = bookUserRepository;
    }

    @Override
    public void run(String... args) {
        initializeBookUsers();
    }

    private void initializeBookUsers() {
        // Sample data
      //   Book book1 = new Book("Book One");
      //   Book book2 = new Book("Book Two");

      //   Users user1 = new Users("User 1");
      //   Users user2 = new Users("User 2");

      //   // Create and save BookUser entities
      //   BookUser bookUser1 = new BookUser(book1, user1);
      //   bookUserRepository.save(bookUser1);

      //   BookUser bookUser2 = new BookUser(book2, user1);
      //   bookUserRepository.save(bookUser2);

      //   BookUser bookUser3 = new BookUser(book1, user2);
      //   bookUserRepository.save(bookUser3);

      
      Random randomGenerator=new Random();

      for(int i=1; i<=40; i++){
         int userId = randomGenerator.nextInt(50) + 1;
         int bookId = randomGenerator.nextInt(10) + 1;
         BookUser bookUser = new BookUser(bookId,userId);
         bookUserRepository.save(bookUser);
      }
    }
}