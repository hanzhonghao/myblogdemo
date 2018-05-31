package com.zhonghao.mapper;



import com.zhonghao.entity.SysParam;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysParamMapper {

    int insertSysParam(SysParam sysParam);

}
