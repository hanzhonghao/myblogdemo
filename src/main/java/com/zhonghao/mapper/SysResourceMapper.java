package com.zhonghao.mapper;

import com.zhonghao.entity.SysResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysResourceMapper {

    int saveList(List<SysResource> list);

    int delete(Long id);

    int update(SysResource e);

    SysResource findById(Long id);

    List<SysResource> findAll();

    List<SysResource> findByUserId(long userId);
}
