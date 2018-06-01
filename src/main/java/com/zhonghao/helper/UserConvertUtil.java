package com.zhonghao.helper;


import com.zhonghao.entity.User;
import com.zhonghao.model.dto.UserDTO;
import com.zhonghao.common.util.DozerUtil;

public final class UserConvertUtil {
    
    public static User userDTO2User(UserDTO userDTO, User user) {
        if(user == null) {
            user = new User();
        }
        DozerUtil.map(userDTO, user);
        return user;
    }

}
