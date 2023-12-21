package com.winmanboo.bluebook.main.controller;

import com.winmanboo.bluebook.base.BaseController;
import com.winmanboo.bluebook.result.Result;
import com.winmanboo.bluebook.main.mapping.CategoryMapping;
import com.winmanboo.bluebook.main.service.CategoryService;
import com.winmanboo.bluebook.main.vo.CategoryVO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 类目表 前端控制器
 * </p>
 *
 * @author winmanboo
 * @since 2023-12-13
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/main/category")
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    private final CategoryMapping categoryMapping;

    @GetMapping("/list")
    @ApiOperation(value = "类目集合", notes = "类目集合")
    public Result<List<CategoryVO>> list() {
        return ok(categoryMapping.toCategoryVos(categoryService.list()));
    }
}
