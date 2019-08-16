package cn.jmu.mapper;

import java.util.List;

import cn.jmu.entity.User;


public interface UserDao {
	int addUser(User user);
	User login(User user);
}
