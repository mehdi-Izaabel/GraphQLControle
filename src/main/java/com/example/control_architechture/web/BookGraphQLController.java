package com.example.control_architechture.web;

import com.example.control_architechture.dtos.BookDTO;
import com.example.control_architechture.service.BookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookGraphQLController {
@Autowired
public BookManager bookManager;
    @QueryMapping
    public List<BookDTO> getBookByTitle(@Argument String title){
        return bookManager.getBookByTitle(title);
    }

    @QueryMapping
    public List<BookDTO> getBookByPublisherAndPrice(@Argument String publisher, @Argument Float price){
        return bookManager.getBookByPublisherAndPrice(publisher,price);
    }

    @MutationMapping
    public BookDTO saveBook(@Argument BookDTO bookDTO){
        return bookManager.saveBook(bookDTO);
    }

    @MutationMapping
    public BookDTO deleteBook(@Argument Long id){
        return bookManager.deleteBook(id);
    }
}
