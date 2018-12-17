package com.luoc.conditiion.config;

import com.luoc.conditiion.DefaultPath;
import com.luoc.conditiion.linux.LinuxCondition;
import com.luoc.conditiion.linux.LinuxPath;
import com.luoc.conditiion.windows.WindowsCondition;
import com.luoc.conditiion.windows.WindowsPath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoc
 * @date 2018/12/12 0012
 * @Time 15:02
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public DefaultPath windows(){
        return new WindowsPath();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public DefaultPath linux(){
        return new LinuxPath();
    }

}
