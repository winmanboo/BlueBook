package com.winmanboo.bluebook.uaa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.uaa.entity.AuthAccount;

/**
 * @author winmanboo
 * @date 2024/1/4 12:49
 */
public interface AuthAccountService extends IService<AuthAccount> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    AuthAccount loadAccountByUsername(String username);
}
