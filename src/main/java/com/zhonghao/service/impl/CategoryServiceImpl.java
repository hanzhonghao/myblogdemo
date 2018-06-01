package com.zhonghao.service.impl;

import com.zhonghao.common.Result;
import com.zhonghao.entity.Category;
import com.zhonghao.exception.CategoryException;
import com.zhonghao.helper.CategoryConvertUtil;
import com.zhonghao.mapper.CategoryMapper;
import com.zhonghao.model.dto.CategoryDTO;
import com.zhonghao.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.zhonghao.enums.CategoryExceptionEnum.NOT_FOUND_CATEGORY;


/**
 * @author tt
 */
@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {
    
    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    @Override
    public Result<?> addCategory(CategoryDTO categoryDTO) {
    	
        if(categoryDTO == null) {
        	log.error("categoryDTO is null");
            throw new IllegalArgumentException("参数错误");
        }
        
        if(categoryDTO.getId() == null) {
            Category category = CategoryConvertUtil.categoryDTO2Category(categoryDTO, null);
            long now = System.currentTimeMillis();
            category.setCreateTime(now);
            category.setCreateUser(categoryDTO.getUpdateUser());
            category.setUpdateTime(now);
            int row = categoryMapper.save(category);
            return row > 0 ? Result.success("添加成功", category) : Result.fail("添加失败");
        }
        Category category = categoryMapper.findById(categoryDTO.getId());
        if(category == null) {
            throw new CategoryException(NOT_FOUND_CATEGORY);
        }
        CategoryConvertUtil.categoryDTO2Category(categoryDTO, category);
        long now = System.currentTimeMillis();
        category.setUpdateTime(now);
        int row = categoryMapper.update(category);
        return row > 0 ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @Override
    public List<Category> getCategorys(Long userId) {
        return categoryMapper.findByUserId(userId);
    }

}
