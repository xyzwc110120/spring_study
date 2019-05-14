package com.cyx.spring._24_spring_transaction_xml.dao.impl;

import com.cyx.spring._24_spring_transaction_xml.dao.TransferDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TransferDAOImpl implements TransferDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void transferOut(Long memberId, Integer money) {
        jdbcTemplate.update("UPDATE member SET balance = balance - ? WHERE id = ?", money, memberId);
    }

    @Override
    public void transferIn(Long memberId, Integer money) {
        jdbcTemplate.update("UPDATE member SET balance = balance + ? WHERE id = ?", money, memberId);

    }
}
