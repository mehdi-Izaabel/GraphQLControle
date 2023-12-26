package com.example.control_architechture;

import com.example.control_architechture.dao.entities.Book;
import com.example.control_architechture.dao.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

import static graphql.introspection.IntrospectionQueryBuilder.build;

@SpringBootApplication
public class ControlArchitechtureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlArchitechtureApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BookRepository bookRepository) {
        return args -> {

            List<Book> books = List.of(
                    Book.builder().title("A").publisher("publisher1").datePublication("26/12/2023").price(200.0f).resume("resume").build(),
                    Book.builder().title("B").publisher("publisher1").datePublication("26/12/2023").price(300.0f).resume("resume").build(),
                    Book.builder().title("C").publisher("publisher1").datePublication("26/12/2023").price(400.0f).resume("resume").build(),
                    Book.builder().title("D").publisher("publisher1").datePublication("26/12/2023").price(500.0f).resume("resume").build()
            );
            bookRepository.saveAll(books);


        };
    }
}