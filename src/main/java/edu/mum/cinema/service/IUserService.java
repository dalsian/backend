package edu.mum.cinema.service;

import java.util.List;

import edu.mum.cinema.model.User;

public interface IUserService {
	long save(User user);
	User get(long id);
	List<User> getAll();
	void update(long id, User user);
	void delete(long id);
	User authenticate(String userName, String password);
	User changePassword(Long id, String pass);
}
