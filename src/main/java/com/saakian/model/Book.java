package com.saakian.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class Book {
    private int id;
    private String title;
    private String author;
    private Date date_added;
}
