package com.zhonghao.service;


import com.zhonghao.common.Result;
import com.zhonghao.common.security.IUser;
import com.zhonghao.model.dto.SysParamDTO;
import com.zhonghao.model.vo.SysParamVO;

public interface SystemService {

    /**
     * 获取所有系统参数
     * @return
     */
    SysParamVO getAllSysParam();

    /**
     * 添加参数
     * @param sysParamDTO
     * @param user
     * @return
     */
    Result<?> save(SysParamDTO sysParamDTO, IUser user);
}
