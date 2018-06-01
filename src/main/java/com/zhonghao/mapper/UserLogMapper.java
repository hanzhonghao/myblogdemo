package com.zhonghao.mapper;

import com.zhonghao.entity.UserLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserLogMapper {

    int save(UserLog userLog);

    int delete(Long id);

    int update(UserLog userLog);

    UserLog findByUserId(Long userId);

    List<UserLog> findAll();

}
