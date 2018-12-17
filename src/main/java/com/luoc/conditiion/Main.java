package com.luoc.conditiion;

import com.luoc.conditiion.config.ConditionConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author luoc
 * @date 2018/12/12 0012
 * @Time 14:59
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        DefaultPath defaultPath = context.getBean(DefaultPath.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+"____"+defaultPath.getDefaultPath());
    }
}
