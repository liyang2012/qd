package cn.com.myproject.qd.service;

import cn.com.myproject.qd.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAll(int type);

    int add(User user);

    int update(User user);

    User get(String phone,int type);

    int delete(Integer id);
}
