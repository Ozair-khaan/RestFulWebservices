package com.rest.practice.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.practice.bean.User;

@Component
public class UserDaoService {

	public static int usersCount = 5;

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Ozair", new Date()));
		users.add(new User(2, "Ranjit", new Date()));
		users.add(new User(3, "Namita", new Date()));
		users.add(new User(4, "Anjali", new Date()));
		users.add(new User(5, "Nikhil", new Date()));
		users.add(new User(6, "Prathmesh", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		{
			if (user.getId() == null) {
				user.setId(++usersCount);
			}
			users.add(user);
		}
		return user;
	}

	public User findOne(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
