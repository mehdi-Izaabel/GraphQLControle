package com.example.control_architechture.mappers;

import com.example.control_architechture.dao.entities.Book;
import com.example.control_architechture.dtos.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public BookDTO fromBookToBookDTO(Book book){
        return this.modelMapper.map(book,BookDTO.class);
    }

    public Book fromBookDTOToBook(BookDTO bookDTO){
        return this.modelMapper.map(bookDTO,Book.class);
    }

}
