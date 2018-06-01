package com.zhonghao.model.dto;

import com.zhonghao.common.bean.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Setter
@Getter
@ToString
public class SysParamDTO extends BaseDTO {

    @NotBlank(message = "参数名称不能为空")
    private String paramName;
    @NotBlank(message = "c桉树值不能为空")
    private String paramValue;

}
