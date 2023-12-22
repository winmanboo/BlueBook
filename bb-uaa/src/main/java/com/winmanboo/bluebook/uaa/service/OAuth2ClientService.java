package com.winmanboo.bluebook.uaa.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.winmanboo.bluebook.api.uaa.vo.OAuth2ClientVo;
import com.winmanboo.bluebook.api.uaa.dto.OAuth2ClientDTO;
import com.winmanboo.bluebook.base.PageList;
import com.winmanboo.bluebook.base.PageParam;
import com.winmanboo.bluebook.uaa.entity.OAuth2Client;

/**
 * @author winmanboo
 * @date 2023/7/19 13:02
 */
public interface OAuth2ClientService extends IService<OAuth2Client> {
    /**
     * 分页信息
     *
     * @param pageParam       页面参数
     * @param oAuth2ClientDTO 客户端查询参数
     * @return {@link PageList}<{@link OAuth2ClientVo}>
     */
    PageList<OAuth2ClientVo> pageVo(PageParam pageParam, OAuth2ClientDTO oAuth2ClientDTO);

    /**
     * 更新
     *
     * @param oAuth2ClientDTO o auth2客户dto
     */
    void update(OAuth2ClientDTO oAuth2ClientDTO);
}
