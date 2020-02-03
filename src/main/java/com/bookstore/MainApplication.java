package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    private final BookstoreService bookstoreService;

    public MainApplication(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            
            System.out.println("\n-----------------------");
            System.out.println("---------REMOVE--------");
            System.out.println("-----------------------\n");
            bookstoreService.softDeleteAuthor();
            bookstoreService.softDeleteBook();
           
            bookstoreService.displayAllIncludeDeletedAuthors();
            bookstoreService.displayAllExceptDeletedAuthors();
            bookstoreService.displayAllOnlyDeletedAuthors();

            bookstoreService.displayAllIncludeDeletedBooks();
            bookstoreService.displayAllExceptDeletedBooks();
            bookstoreService.displayAllOnlyDeletedBooks();
            
            System.out.println("\n-----------------------");
            System.out.println("---------RESTORE-------");
            System.out.println("-----------------------\n");            
            bookstoreService.restoreAuthor();
            bookstoreService.restoreBook();
           
            bookstoreService.displayAllIncludeDeletedAuthors();
            bookstoreService.displayAllExceptDeletedAuthors();
            bookstoreService.displayAllOnlyDeletedAuthors();

            bookstoreService.displayAllIncludeDeletedBooks();
            bookstoreService.displayAllExceptDeletedBooks();
            bookstoreService.displayAllOnlyDeletedBooks();
        };
    }
}


/*
 * 
 * 
 * 
 * 
 * How To Use Hibernate Soft Deletes In A Spring Boot Application

Description: This application is an example of using Hibernate soft deletes in a Spring Boot application.

Key points:

define an abstract class BaseEntity with a field named deleted
the entities (e.g., Author and Book entities) that should take advantage of soft deletes should extend BaseEntity
these entities should be marked with Hibernate, @Where annotation like this: @Where(clause = "deleted = false")
these entities should be marked with Hibernate, @SQLDelete annotation to trigger UPDATE SQLs in place of DELETE SQLs, as follows: @SQLDelete(sql = "UPDATE author SET deleted = true WHERE id = ?")
for fetching all entities including those marked as deleted or for fetching only the entities marked as deleted we need to rely on SQL native queries
Output example:
 * 
 * 
 * 
 * 
 */
