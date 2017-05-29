package com.ciurea.andrei.dao;

import com.ciurea.andrei.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by Andrei on 5/27/2017.
 */
@Repository("mysqlEvents")
public class MysqlEventDao implements EventDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class EventRowMapper implements RowMapper<Event> {

        @Override
        public Event mapRow(ResultSet resultSet, int i) throws SQLException {
            Event event = new Event();
            event.setId(resultSet.getInt("id"));
            event.setName(resultSet.getString("name"));
            event.setLocation(resultSet.getString("location"));
            event.setDate(resultSet.getString("date"));
            return event;
        }
    }

    @Override
    public Collection<Event> getAllEvents() {
        final String sql = "SELECT * FROM events";
        List<Event> events = jdbcTemplate.query(sql, new EventRowMapper());
        return events;
    }
}
