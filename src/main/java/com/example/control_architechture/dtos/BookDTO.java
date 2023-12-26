package com.example.control_architechture.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BookDTO {
    String title;
    String publisher;
    String datePublication;
    Float price;
    String resume;
}
