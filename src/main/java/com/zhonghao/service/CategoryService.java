package com.zhonghao.service;


import com.zhonghao.common.Result;
import com.zhonghao.entity.Category;
import com.zhonghao.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    
    /**
     * 添加分类
     * @param categoryDTO
     * @return
     */
    Result<?> addCategory(CategoryDTO categoryDTO);

    /**
     * 获取用户分类
     * @param userId
     * @return
     */
    List<Category> getCategorys(Long userId);

}
