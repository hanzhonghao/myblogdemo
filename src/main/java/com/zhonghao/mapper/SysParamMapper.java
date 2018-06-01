package com.zhonghao.mapper;



import com.zhonghao.entity.SysParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface SysParamMapper {

    int save(SysParam e);

    int delete(String paramName);

    int update(SysParam e);

    SysParam findByName(String paramName);

    List<SysParam> findAll();
}
