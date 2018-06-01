package com.zhonghao.model.dto;

import com.zhonghao.common.bean.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class ResourceDTO extends BaseDTO {

    private static final long serialVersionUID = 3826737058144905178L;
    
    private String url;

}
