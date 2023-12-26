package com.example.control_architechture.dao.repositories;

import com.example.control_architechture.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> findByTitle(String title);
    List<Book> findByPublisherAndPrice(String publisher, Float price);
    boolean findByTitleAndPublisher(String title, String publisher);
}
