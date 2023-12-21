package com.winmanboo.bluebook.admin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.admin.dto.UserDTO;
import com.winmanboo.bluebook.admin.entity.User;
import com.winmanboo.bluebook.admin.mapper.UserMapper;
import com.winmanboo.bluebook.admin.mapping.UserMapping;
import com.winmanboo.bluebook.admin.service.UserService;
import com.winmanboo.bluebook.admin.vo.UserVo;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.exception.JiamingException;
import com.winmanboo.bluebook.security.context.UserInfoContext;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author winmanboo
 * @since 2023-05-20
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final UserMapping userMapping;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public PageList<UserVo> pageList(PageParam pageParam, UserDTO userDTO) {
        IPage<UserVo> page = baseMapper.pageList(pageParam.toPage(), userDTO);
        return PageList.turnTo(page);
    }

    @Override
    public void changeUserStatus(Long id, Integer status) {
        lambdaUpdate().eq(User::getId, id).set(User::getStatus, status).update();
    }

    @Override
    public boolean addUser(UserDTO userDTO) {
        User dbUser = lambdaQuery().eq(User::getUsername, userDTO.getUsername()).one();
        if (Objects.nonNull(dbUser)) {
            throw new JiamingException("用户名已存在");
        }

        User user = userMapping.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreator(UserInfoContext.get().getUsername());
        user.setTenantId(UserInfoContext.get().getTenantId());

        return this.save(user);
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        User user = userMapping.toUser(userDTO);
        return lambdaUpdate().eq(User::getId, userDTO.getId())
                .set(User::getUpdater, UserInfoContext.get().getUsername())
                .update(user);
    }

    @Override
    public UserVo getUserInfo(Long userId) {
        if (Objects.isNull(userId)) {
            throw new JiamingException("用户 id 不能为空");
        }
        return baseMapper.getUserInfo(userId);
    }

    @Override
    public boolean resetPassword(Long userId, String password) {
        User user = this.getById(userId);
        if (Objects.isNull(user)) {
            throw new JiamingException("用户不存在");
        }
        return lambdaUpdate().eq(User::getId, userId).set(User::getPassword, passwordEncoder.encode(password)).update();
    }

    @Override
    public List<UserVo> leaderList() {
        return baseMapper.leaderList();
    }
}
