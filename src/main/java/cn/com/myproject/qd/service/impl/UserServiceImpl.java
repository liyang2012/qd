package cn.com.myproject.qd.service.impl;

import cn.com.myproject.qd.dao.UserMapper;
import cn.com.myproject.qd.model.User;
import cn.com.myproject.qd.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ly
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll(int type) {
        return userMapper.getAll(type);
    }

    @Override
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User get(String phone,int type) {
        return userMapper.get(phone,type);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }
}
