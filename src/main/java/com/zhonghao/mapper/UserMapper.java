package com.zhonghao.mapper;

import com.zhonghao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 */
@Mapper
public interface UserMapper {

    int save(User user);

    int delete(Long id);

    int updateByUsername(User user);

    User findByUsername(String username);

    List<User> findAll();

}
