package com.example.control_architechture.service;

import com.example.control_architechture.dao.entities.Book;
import com.example.control_architechture.dao.repositories.BookRepository;
import com.example.control_architechture.dtos.BookDTO;
import com.example.control_architechture.mappers.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookManagerAction implements BookManager{

    @Autowired
    public BookRepository bookRepository;
    @Autowired
    public BookMapper bookMapper;
    @Override
    public List<BookDTO> getBookByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book book : books){
            BookDTO bookDTO = bookMapper.fromBookToBookDTO(book);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price) {
        List<Book> books = bookRepository.findByPublisherAndPrice(publisher,price);
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book book : books){
            BookDTO bookDTO = bookMapper.fromBookToBookDTO(book);
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
       /* if(!bookRepository.findByTitleAndPublisher(bookDTO.getTitle(), bookDTO.getPublisher()))
        {
            return null;
        }*/

        Book book = bookMapper.fromBookDTOToBook(bookDTO);
        book = bookRepository.save(book);
        bookDTO = bookMapper.fromBookToBookDTO(book);
        return bookDTO;
    }

    @Override
    public BookDTO deleteBook(Long id) {
        Book book = bookRepository.findById(id).get();
        bookRepository.delete(book);
        return null;
    }
}
