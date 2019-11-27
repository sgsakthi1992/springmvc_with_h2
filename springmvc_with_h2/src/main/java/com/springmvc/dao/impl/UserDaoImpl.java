package com.springmvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.UserDao;
import com.springmvc.model.Users;
import com.springmvc.rowmapper.UserRowMapper;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	UserDao userDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	@Transactional
	public List<Users> getUsers() {
		List<Users> usersList = (List<Users>) jdbcTemplate.query("select * from users", new UserRowMapper());
		return usersList;
	}

	@Override
	@Transactional
	public void save(Users user) {
		SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("USERS").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("firstName", user.getFirstName());
		parameters.put("lastName", user.getLastName());
		parameters.put("phoneNumber", user.getPhoneNumber());
		parameters.put("phoneCompany", user.getPhoneCompany());
		simpleJdbcInsert.executeAndReturnKey(parameters);
	}

}
