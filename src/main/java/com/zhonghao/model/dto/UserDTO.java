package com.zhonghao.model.dto;


import com.zhonghao.common.bean.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
@ToString
public class UserDTO extends BaseDTO {

    @NotEmpty(message = "用户名不能为空")
    private String username;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private String nickName;

}
