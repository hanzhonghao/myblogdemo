package com.zhonghao.controller;

import com.zhonghao.common.Result;
import com.zhonghao.common.annotation.Security;
import com.zhonghao.common.security.IUser;
import com.zhonghao.common.security.SessionUserContext;
import com.zhonghao.model.vo.ResourceVO;
import com.zhonghao.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Security
    @RequestMapping(value = "/getPic")
    @ResponseBody
    public Result<?> getPic() {
        IUser user = SessionUserContext.get();
        List<ResourceVO> list = resourceService.getAllResource(user.getId());
        return Result.success("ok", list);
    }

    @Security
    @RequestMapping(value = "/upload")
    @ResponseBody
    public Result<?> upload(HttpServletRequest request) {
        log.debug("==== upload start ====");
        IUser user = SessionUserContext.get();
        return resourceService.saveResource(request, user);
    }


}
