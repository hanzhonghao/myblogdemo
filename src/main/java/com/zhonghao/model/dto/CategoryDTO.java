package com.zhonghao.model.dto;

import com.zhonghao.common.bean.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
@ToString
public class CategoryDTO extends BaseDTO {
    
    private static final long serialVersionUID = -3367173869874734353L;
    
    private Long id;
    
    @NotEmpty(message = "分类名称不能为空")
    private String name;

    @NotEmpty(message = "分类别名不能为空")
    private String aliasName;

}
