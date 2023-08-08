package com.db.grad.javaapi.model.initializer;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BookInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    @Autowired
    public BookInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
       
      for(int i=1; i<=10; i++){
         String bookName = ("Book " + i);
         Book book = new Book(bookName);
         bookRepository.save(book);
      }

    }

}
