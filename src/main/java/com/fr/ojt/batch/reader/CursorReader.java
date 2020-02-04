package com.fr.ojt.batch.reader;

import com.fr.ojt.batch.model.Order;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class CursorReader {
    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/batch");
        dataSource.setUsername("root");
        dataSource.setPassword("pass");

        return dataSource;
    }

    public JdbcCursorItemReader read(){
        JdbcCursorItemReader<Order> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource());
        reader.setSql(" SELECT * FROM ojt.order;");
        reader.setRowMapper(new BeanPropertyRowMapper<>(Order.class));

        return reader;
    }
}
