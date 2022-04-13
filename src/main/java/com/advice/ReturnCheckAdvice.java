package com.advice;


import com.annotation.ReturnCheck;
import com.enums.ErrorCodeEnum;
import com.exception.ErrorCodeException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author 赵官乔
 * @Date 2022/4/9
 */
@Slf4j
@Aspect
@Component
public class ReturnCheckAdvice {

    /**
     * 操作数据库影响行数判断切面(dao方法上标注@ReturnCheck,通过注解的属性expect设置期望返回值,
     * 属性info设置影响行数不为期望返回值时抛出异常的message信息)
     *
     * @param joinPoint 连接点
     * @param result    实际影响行数
     */
    @AfterReturning(returning = "result", pointcut = "@annotation(com.annotation.ReturnCheck)")
    public void doAfter(JoinPoint joinPoint, int result) {
        // 获取当前方法
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        ReturnCheck annotation = method.getDeclaredAnnotation(ReturnCheck.class);
        // 获取注解内期望返回值
        int expect = annotation.expect();
        if (expect != result) {
            throw new ErrorCodeException(ErrorCodeEnum.ERROR, annotation.info());
        }
    }
}