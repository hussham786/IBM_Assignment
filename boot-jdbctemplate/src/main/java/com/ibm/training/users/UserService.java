package com.ibm.training.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.bean.User;

@Service
public class UserService {
	@Autowired
	UserDao dao;
	
	public User getUser(int userId) {
		
		return dao.getUser(userId);
	}

	public List<User> getUsers() {
		
		return dao.getUsers();
	}

	public void insertUser(User user) {
		dao.insertUser(user);
		
	}

	public void updateUser(User user, Integer id) {
		dao.updateUser(user, id);
		
	}

	public void deleteUser(Integer id) {
		dao.deleteUser(id);
		
	}

}
