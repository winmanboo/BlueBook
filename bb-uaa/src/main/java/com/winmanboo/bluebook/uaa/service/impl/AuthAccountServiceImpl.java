package com.winmanboo.bluebook.uaa.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.winmanboo.bluebook.uaa.entity.AuthAccount;
import com.winmanboo.bluebook.uaa.mapper.AuthAccountMapper;
import com.winmanboo.bluebook.uaa.service.AuthAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author winmanboo
 * @date 2024/1/4 12:50
 */
@Service
@RequiredArgsConstructor
public class AuthAccountServiceImpl extends ServiceImpl<AuthAccountMapper, AuthAccount> implements AuthAccountService {

    @Override
    public AuthAccount loadAccountByUsername(String username) {
        boolean condition = CharSequenceUtil.isNotEmpty(username);
        return lambdaQuery().eq(condition, AuthAccount::getUsername, username).one();
    }
}
