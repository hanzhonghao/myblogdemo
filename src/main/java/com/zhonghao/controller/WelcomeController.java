package com.zhonghao.controller;

import com.zhonghao.model.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static javafx.scene.input.KeyCode.R;


/**
 * Created by zhonghao.han on 5/28/2018.
 */
@Controller
public class WelcomeController {

    @RequestMapping(value = {"/index"})
    @ResponseBody
    public String index() {
        return "hello, mvc-velocity";
    }

    @RequestMapping(value = {"/", ""})
    public ModelAndView index2() {
        ModelAndView mv = new ModelAndView("test");
        mv.addObject("user", "水门");
        return mv;
    }

    @RequestMapping(value = {"test"})
    public String test(ModelMap map) {
        map.put("user", "水门2");
        return "index";
    }

    @RequestMapping("validator")
    @ResponseBody
    public String validator(@Valid TestVO testVO, BindingResult result) {
        if (result.hasErrors()) {
            return result.getAllErrors().get(0).getDefaultMessage();
        }
        return "validator";
    }

    @RequestMapping("exception")
    @ResponseBody
    public String testException(){
        int i = 1/0;
        return "exception";
    }

}
