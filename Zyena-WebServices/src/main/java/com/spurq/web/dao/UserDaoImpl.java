package com.spurq.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spurq.web.domain.User;
import com.spurq.web.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	 DataSource dataSource;

	 public boolean insertData(User user) {

	  String sql = "INSERT INTO user "
	    + "(fname, lname, email, pass) VALUES (?, ?, ?,?)";

	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,
	    new Object[] { user.getFirstName(), user.getLastName(),
	      user.getEmail(), user.getPassword() });
	  
	  return true;

	 }

	 public List<User> getUserList() {
	  List<User> userList = new ArrayList<User>();

	  String sql = "select * from user";

	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  userList = jdbcTemplate.query(sql, new UserRowMapper());
	  return userList;
	 }

	 public boolean deleteData(String id) {
	  String sql = "delete from user where uid=" + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  jdbcTemplate.update(sql);
	  
	  return true;

	 }

	 public boolean updateData(User user) {

	  String sql = "UPDATE user set fname = ?,lname = ?, email = ?, pass = ? where uid = ?";
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	  jdbcTemplate.update(
	    sql,
	    new Object[] { user.getFirstName(), user.getLastName(),
	      user.getEmail(), user.getPassword(), user.getUserId() });
	  return true;
	 }

	 public User getUser(String id) {
	  List<User> userList = new ArrayList<User>();
	  String sql = "select * from user where uid = " + id;
	  JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	  userList = jdbcTemplate.query(sql, new UserRowMapper());
	  return userList.get(0);
	 }

	}

