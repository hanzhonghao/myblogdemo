package com.zhonghao.test;

import com.zhonghao.MyblogdemoApplication;
import com.zhonghao.entity.SysParam;
import com.zhonghao.mapper.SysParamMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by zhonghao.han on 5/31/2018.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyblogdemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class TestSysParamMapper {

    @Resource
    private SysParamMapper sysParamMapper;

    @Test
    @Rollback(true)
    public void testInsertSysParam() throws Exception {
        SysParam param = new SysParam();
        long now = System.currentTimeMillis();
        param.setCreateTime(now);
        param.setCreateUser(0L);
        param.setParamName("hzh");
        param.setParamValue("123");
        param.setUpdateUser(0L);
        param.setUpdateTime(now);
//        int row = sysParamMapper.insertSysParam(param);
//        Assert.assertEquals(1,row);
        log.debug("ok...");
    }
}
