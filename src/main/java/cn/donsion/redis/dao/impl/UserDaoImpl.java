package cn.donsion.redis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

import cn.donsion.redis.dao.UserDao;
import cn.donsion.redis.vo.User;

public class UserDaoImpl implements UserDao {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public void save(User user) {
		
	}

	public void delete(Integer id) {

	}

	public void update(User user) {

	}

	public int getCount() {
		return 0;
	}

	public List<User> getAllUser() {
		return null;
	}

}
