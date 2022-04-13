package com.advice;

import com.enity.MessageBean;
import com.enums.ErrorCodeEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author 赵冠乔
 * @Date 2022/4/13
 */

@RestControllerAdvice
public class NotValidAdvice {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public MessageBean notValidR(BindException e) {
        return new MessageBean(ErrorCodeEnum.INVALID_PARAMS, e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
