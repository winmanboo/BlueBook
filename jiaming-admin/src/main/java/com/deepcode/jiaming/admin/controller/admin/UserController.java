package com.deepcode.jiaming.admin.controller.admin;

import com.deepcode.jiaming.admin.service.UserService;
import com.deepcode.jiaming.admin.vo.UserVo;
import com.deepcode.jiaming.result.Result;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/user")
public class UserController {
    private final UserService userService;

    // FIXME: 2023/7/5 使用 OIDC 获取用户信息：https://docs.spring.io/spring-authorization-server/docs/1.0.3/reference/html/guides/how-to-userinfo.html
    @GetMapping("/info")
    @ApiOperation(value = "用户信息", notes = "获取当前登录的用户信息")
    public Result<UserVo> userInfo() {
        UserVo userVo = userService.getCurrentUserInfo();
        return Result.ok(userVo);
    }
}
