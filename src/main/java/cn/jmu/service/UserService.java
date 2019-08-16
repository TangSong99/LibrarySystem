package cn.jmu.service;

import java.util.List;

import cn.jmu.entity.User;

public interface UserService {
	User login(User user);
	int addUser(User user);

	int test();
}
