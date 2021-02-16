package cn.com.myproject.qd.dao;



import cn.com.myproject.qd.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @author ly
 */
@Mapper
@Component
public interface UserMapper {

    List<User> getAll(@Param("type") int type);

    int insert(User user);

    int update(User user);

    User get(@Param("phone") String phone,@Param("type") int type);

    List<User> getByPhone(@Param("phone") String phone);

    int delete(Integer id);

}