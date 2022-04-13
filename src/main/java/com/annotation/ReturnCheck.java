package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库修改返回值检查注解
 *
 * @author 赵冠乔
 * @date 2022/4/5
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ReturnCheck {

    /**
     * 期望返回值
     */
    int expect() default 1;

    /**
     * 不为期望返回值时返回信息
     */
    String info() default "处理成功";
}
