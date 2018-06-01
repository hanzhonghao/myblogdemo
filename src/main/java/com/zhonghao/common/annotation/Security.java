package com.zhonghao.common.annotation;

import java.lang.annotation.*;

/**
 * Created by zhonghao.han on 6/1/2018.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Security {

    String name() default "";
    String type() default "";
}
