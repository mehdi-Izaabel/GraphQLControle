package com.example.control_architechture.service;

import com.example.control_architechture.dtos.BookDTO;

import java.util.List;

public interface BookManager {
    //getBookByTitle(title:String):[BookDTO]
    public List<BookDTO> getBookByTitle(String title);

    //getBookByPublisherAndPrice(publisher:String,price:Float):[BookDTO]
    public List<BookDTO> getBookByPublisherAndPrice(String publisher, Float price);

    //saveBook(book:BookDTOInput):BookDTO
    public BookDTO saveBook(BookDTO bookDTO);

    //deleteBook(id:ID):BookDTO
    public BookDTO deleteBook(Long id);

}
