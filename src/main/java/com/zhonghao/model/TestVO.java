package com.zhonghao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by zhonghao.han on 5/31/2018.
 */
@Setter
@Getter
@ToString
public class TestVO {
//    @Size(min = 10,max = 20,message = "id大小在{min}到{max}之间")
    @Min(value = 10,message = "id大小必须大于等于10")
    @Max(value = 20,message = "id大小必须小于等于20")

    private String id;
    @NotBlank(message = "名字不能为空")
    private String name;
}
