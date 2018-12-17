package com.luoc.conditiion.linux;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author luoc
 * @date 2018/12/12 0012
 * @Time 14:51
 */
public class LinuxCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
         return context.getEnvironment().getProperty("os.name").contains("Linux");
    }
}
