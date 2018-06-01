package com.zhonghao.test;

import com.zhonghao.MyblogdemoApplication;
import com.zhonghao.common.Result;
import com.zhonghao.model.dto.UserDTO;
import com.zhonghao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogdemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class TestUserService {

    @Resource
    private UserService userService;

    @Rollback(false)
    @Test
    public void testSaveUser() throws Exception {
        UserDTO e = new UserDTO();
        e.setUsername("admin");
        e.setPassword("123456");
        e.setNickName("admin");
        Result<?> result = userService.saveUser(e);
        Assert.assertEquals(0, result.getCode());
    }
}
