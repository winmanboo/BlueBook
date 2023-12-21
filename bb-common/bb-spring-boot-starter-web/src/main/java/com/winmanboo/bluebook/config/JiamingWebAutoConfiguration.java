package com.winmanboo.bluebook.config;

import com.winmanboo.bluebook.properties.WebProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author winmanboo
 * @date 2023/12/13 16:58
 */
@AutoConfiguration
@EnableConfigurationProperties(value = WebProperties.class)
public class JiamingWebAutoConfiguration {
}
