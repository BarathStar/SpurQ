package com.spurq.web.dao;

import java.util.List;

import com.spurq.web.domain.User;

public interface UserDao {
	public boolean insertData(User user);
	 public List<User> getUserList();
	 public boolean updateData(User user);
	 public boolean deleteData(String id);
	 public User getUser(String id);


}
