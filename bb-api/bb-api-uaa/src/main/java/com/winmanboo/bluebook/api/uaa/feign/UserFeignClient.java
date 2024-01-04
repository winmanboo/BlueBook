package com.winmanboo.bluebook.api.uaa.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author winmanboo
 * @date 2023/12/22 16:49
 */
@FeignClient(value = "bb-uaa", contextId = "user")
public interface UserFeignClient {
}
