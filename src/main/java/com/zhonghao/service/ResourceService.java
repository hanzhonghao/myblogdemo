package com.zhonghao.service;


import com.zhonghao.common.Result;
import com.zhonghao.common.security.IUser;
import com.zhonghao.model.vo.ResourceVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ResourceService {

    List<ResourceVO> getAllResource(long userId);

    Result<List<ResourceVO>> saveResource(HttpServletRequest request, IUser user);

}
