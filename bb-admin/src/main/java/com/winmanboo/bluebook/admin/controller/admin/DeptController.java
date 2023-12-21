package com.winmanboo.bluebook.admin.controller.admin;

import com.winmanboo.bluebook.admin.dto.DeptDTO;
import com.winmanboo.bluebook.admin.entity.Dept;
import com.winmanboo.bluebook.admin.mapping.DeptMapping;
import com.winmanboo.bluebook.admin.service.DeptService;
import com.winmanboo.bluebook.admin.vo.DeptVo;
import com.winmanboo.bluebook.result.Result;
import com.winmanboo.bluebook.valid.AddGroup;
import com.winmanboo.bluebook.valid.UpdateGroup;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/dept")
public class DeptController {

    private final DeptService deptService;

    private final DeptMapping deptMapping;

    @GetMapping("/list")
    @ApiOperation(value = "部门列表", notes = "部门列表（树型结构）")
    public Result<List<DeptVo>> depts(DeptDTO deptDTO) {
        List<DeptVo> depts = deptService.listDeptVo(deptDTO);
        return Result.ok(depts);
    }

    @GetMapping("/info/{deptId}")
    @ApiOperation(value = "部门信息", notes = "根据部门 id 查询部门信息")
    public Result<DeptVo> info(@PathVariable Long deptId) {
        Dept dept = deptService.getById(deptId);
        DeptVo deptVo = deptMapping.toDeptVo(dept);
        return Result.ok(deptVo);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增部门", notes = "新增部门")
    public Result<Void> add(@Validated(AddGroup.class) @RequestBody DeptDTO deptDTO) {
        Dept dept = deptMapping.toDept(deptDTO);
        return Result.valid(deptService.save(dept));
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新部门", notes = "根据 id 更新部门")
    public Result<Void> update(@Validated(UpdateGroup.class) @RequestBody DeptDTO deptDTO) {
        Dept dept = deptMapping.toDept(deptDTO);
        return Result.valid(deptService.updateById(dept));
    }

    @DeleteMapping("/remove/{deptId}")
    @ApiOperation(value = "删除部门", notes = "根据 id 删除部门")
    public Result<Void> remove(@PathVariable Long deptId) {
        return Result.valid(deptService.removeById(deptId));
    }
}
