package com.zhonghao.helper;


import com.zhonghao.entity.Category;
import com.zhonghao.model.dto.CategoryDTO;
import com.zhonghao.common.util.DozerUtil;

public final class CategoryConvertUtil {

    public static Category categoryDTO2Category(CategoryDTO categoryDto, Category category) {
        if(category == null) {
            category = new Category();
        }
        DozerUtil.map(categoryDto, category);
        return category;
    }

}
