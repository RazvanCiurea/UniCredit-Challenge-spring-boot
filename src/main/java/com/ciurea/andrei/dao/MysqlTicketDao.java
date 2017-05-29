package com.ciurea.andrei.dao;

import com.ciurea.andrei.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Andrei on 5/27/2017.
 */
@Repository("mysqlTickets")
public class MysqlTicketDao implements TicketDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class TicketRowMapper implements RowMapper<Ticket> {

        @Override
        public Ticket mapRow(ResultSet resultSet, int i) throws SQLException {
            Ticket ticket = new Ticket();
            ticket.setId(resultSet.getInt("id"));
            ticket.setPrice(resultSet.getDouble("price"));
            ticket.setOwner(resultSet.getString("owner"));
            ticket.setEvent(resultSet.getString("event"));
            return ticket;
        }
    }

    @Override
    public void addTicket(Ticket ticket) {
        final String sql = "INSERT INTO tickets (price, owner, event) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{ticket.getPrice(), ticket.getOwner(), ticket.getEvent()});
    }

    @Override
    public void removeTicket(Ticket ticket) {
        final String sql = "DELETE FROM tickets WHERE id = ?";
        jdbcTemplate.update(sql, ticket.getId());
    }

    @Override
    public Ticket getTicket(int id) {
        final String sql = "SELECT id, price, owner, event FROM tickets where id = ?";
        Ticket ticket = jdbcTemplate.queryForObject(sql, new TicketRowMapper(), id);
        return ticket;
    }
}
