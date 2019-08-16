package cn.jmu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jmu.entity.User;
import cn.jmu.mapper.UserDao;
import cn.jmu.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	//@Resource(name="UserDao")
	@Autowired
	private UserDao userDao;
	@Override
	public int addUser(User user)
	{
		return userDao.addUser(user);
	}

	@Override
	public int test() {
		System.out.println("test..........");
		return 0;
	}

	@Override
	public User login(User user) {
		return userDao.login(user);
	}
}
