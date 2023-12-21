package com.winmanboo.bluebook.admin.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.winmanboo.bluebook.admin.dto.UserDTO;
import com.winmanboo.bluebook.admin.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.winmanboo.bluebook.admin.vo.UserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 用户列表
     *
     * @param tenantId 租户 id
     * @param user     用户信息
     * @return {@link List}<{@link UserVo}>
     */
    IPage<UserVo> pageList(@Param("page") IPage<UserVo> page, @Param("user") UserDTO user);

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return {@link UserVo}
     */
    UserVo getUserInfo(@Param("userId") Long userId);

    /**
     * 负责人名单
     *
     * @return {@link List}<{@link UserVo}>
     */
    List<UserVo> leaderList();
}
