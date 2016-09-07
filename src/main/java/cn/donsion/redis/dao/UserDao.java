package cn.donsion.redis.dao;

import java.util.List;

import cn.donsion.redis.vo.User;

public interface UserDao {
	void save(User user);
	void delete(Integer id);
	void update(User user);
	int getCount();
	List<User> getAllUser();
}
