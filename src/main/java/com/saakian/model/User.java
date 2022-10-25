package com.saakian.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class User {
    private String surname;
    private String name;
    private LocalDate birth_day;
    private String phoneNumber;
    private String mail;
    private String[] bookTitles;
}
