package com.zhonghao.controller;

import com.zhonghao.common.Result;
import com.zhonghao.common.annotation.Security;
import com.zhonghao.common.security.IUser;
import com.zhonghao.common.security.SessionUserContext;
import com.zhonghao.model.dto.SysParamDTO;
import com.zhonghao.model.vo.SysParamVO;
import com.zhonghao.service.SystemService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/admin/system")
public class AdminSystemController {

    @Resource
    private SystemService systemService;

    @Security
    @RequestMapping(value = "/setup")
    public ModelAndView setup() {
        ModelAndView mv = new ModelAndView("admin/system/setup");
        SysParamVO sysParamVO = systemService.getAllSysParam();
        mv.addObject("vo", sysParamVO);
        return mv;
    }

    @Security
    @PostMapping(value = "/setupSave")
    @ResponseBody
    public Result<?> setupSave(@Valid SysParamDTO sysParamDTO, BindingResult result) {
        if (result.hasErrors()) {
            return Result.fail(result.getAllErrors().get(0).getDefaultMessage());
        }
        IUser user = SessionUserContext.get();
        return systemService.save(sysParamDTO, user);
    }

}
