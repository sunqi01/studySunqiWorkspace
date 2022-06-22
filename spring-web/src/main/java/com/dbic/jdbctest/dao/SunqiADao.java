package com.dbic.jdbctest.dao;


import org.springframework.jdbc.core.JdbcTemplate;

import com.dbic.jdbctest.entity.SunqiA;

public class SunqiADao {
	
    private JdbcTemplate jdbcTemplate;

	public int add(SunqiA sunqiA) {
        String sql = "INSERT into sunqiA(userId,userName) VALUES(?,?)";
        int update = jdbcTemplate.update(sql, sunqiA.getUserId(), sunqiA.getUserName());
        return update;
    }

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
