package edu.mum.cinema.dao;

import java.util.List;

import edu.mum.cinema.model.User;

public interface IUserDao {
	Long save(User user);
	User get(Long id);
	List<User> getAll();
	void update(Long id, User user);
	void delete(Long id);
	User authenticate(String userName, String password);
}
