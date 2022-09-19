package com.edu.ulab.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String title;
    private int age;
    List<Long> listBooksId;
}
