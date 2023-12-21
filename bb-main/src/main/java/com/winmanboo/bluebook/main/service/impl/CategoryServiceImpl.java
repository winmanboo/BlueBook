package com.winmanboo.bluebook.main.service.impl;

import com.winmanboo.bluebook.main.entity.Category;
import com.winmanboo.bluebook.main.mapper.CategoryMapper;
import com.winmanboo.bluebook.main.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类目表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
