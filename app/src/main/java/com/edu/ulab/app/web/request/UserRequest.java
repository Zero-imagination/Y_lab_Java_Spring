package com.edu.ulab.app.web.request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest {
    private String fullName;
    private String title;
    private int age;
    private List<Long> listBookId;
}
