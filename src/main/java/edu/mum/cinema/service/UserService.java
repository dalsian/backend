package edu.mum.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cinema.dao.IUserDao;
import edu.mum.cinema.model.User;

@Service
@Transactional(readOnly = true)
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Transactional
	@Override
	public long save(User user) {
		return userDao.save(user);
	}

	@Override
	public User get(long id) {
		return userDao.get(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Transactional
	@Override
	public void update(long id, User user) {
		userDao.update(id, user);
	}

	@Transactional
	@Override
	public void delete(long id) {
		userDao.delete(id);
	}

	@Override
	public User authenticate(String userName, String password) {
		
		return userDao.authenticate(userName, password);
	}

}
