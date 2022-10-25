package com.saakian;

import com.saakian.database.dao.UserDAO;
import com.saakian.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@SpringBootApplication
public class Homework6Application {

    private UserDAO userDAO;

    public Homework6Application(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework6Application.class, args);
    }

    @PostConstruct
    public void postConstruct() {

        userDAO.addUserToDb(
                new User("Saakian", "Sergei", LocalDate.of(1987, 6, 7),
                        "+79999999999", "123@mail.ru",
                        new String[]{"Доктор Живаго"}));

        userDAO.getInfoAboutUserBooks("123@mail.ru").forEach(System.out::println);
    }
}
