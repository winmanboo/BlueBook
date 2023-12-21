package com.winmanboo.bluebook.admin.service.impl;

import com.winmanboo.bluebook.admin.entity.GroupUser;
import com.winmanboo.bluebook.admin.mapper.GroupUserMapper;
import com.winmanboo.bluebook.admin.service.GroupUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与用户组关联表 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@Service
public class GroupUserServiceImpl extends ServiceImpl<GroupUserMapper, GroupUser> implements GroupUserService {

}
