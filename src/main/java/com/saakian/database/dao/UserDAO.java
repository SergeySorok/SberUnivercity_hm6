package com.saakian.database.dao;

import com.saakian.model.Book;
import com.saakian.model.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
@Scope("prototype")
public class UserDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;
    private BookDAO bookDAO;

    public void addUserToDb(User user) {
        jdbcTemplate.update("insert into user_hw_6 (surname, name, birth_day, phone_number, mail, books)" +
                        "values (:surname, :name, :birth_day, :phone_number, :mail, :books)",
                new MapSqlParameterSource()
                        .addValue("surname", user.getSurname())
                        .addValue("name", user.getName())
                        .addValue("birth_day", user.getBirth_day())
                        .addValue("phone_number", user.getPhoneNumber())
                        .addValue("mail", user.getMail())
                        .addValue("books", user.getBookTitles())
        );
    }


    public List<Book> getInfoAboutUserBooks(final String mail) {
        List<String[]> booksName = jdbcTemplate.query("select books from user_hw_6 where mail= :mail",
                new MapSqlParameterSource()
                        .addValue("mail", mail),
                (rs, rowNum) -> (String[]) rs.getArray("books").getArray());

        Set<String> books = booksName.stream()
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());

        return bookDAO.getBooksByNames(books);

    }


}

//4. Написать метод, который принимает телефон/почту (на ваше усмотрение), достанет из UserDAO список
//        названий книг данного человека. С этим списком сходить в BookDAO и получить всю информацию
//        об этих книгах
