package com.saakian.database.dao;

import com.saakian.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Component
@Scope("prototype")
public class BookDAO {
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<Book> getBooksByNames(Collection<String> bookTitles) {
        return jdbcTemplate.query("select id, title, author, date_added " +
                        "from books where title in (:titles)",
                new MapSqlParameterSource()
                        .addValue("titles", bookTitles),
                (rs, RowNUm) -> new Book(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4)
                ));
    }
}
