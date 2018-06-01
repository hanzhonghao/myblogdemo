package com.zhonghao.model.vo;

import com.zhonghao.common.bean.IResource;
import com.zhonghao.common.constant.SystemConst;
import lombok.*;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ResourceVO implements IResource {


    private static final long serialVersionUID = -2281334849041660486L;

    private String url;

    @Override
    public String getFullUrl() {
        return SystemConst.STATIC_PREFIX + this.getUrl();
    }
}
