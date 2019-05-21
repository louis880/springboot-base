package com.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 项目配置
 * @author LUJIAWEI931
 * @Date 2019-05-21
 */
@Component
@ConfigurationProperties(prefix = SystemProperties.PREFIX)
@Data
public class SystemProperties {
    public static final String PREFIX = "system-core";

    private Boolean swaggerOpen = false;

}
