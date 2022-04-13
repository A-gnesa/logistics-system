package com.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author 程子涵
 * @Date 2022/3/19
 */
@Getter
@RequiredArgsConstructor
public enum ErrorCodeEnum implements BaseCodeEnum{
    /**
     * 错误码
     */
    ERROR(9999, "系统异常"),
    INVALID_PARAMS(9001, "参数有误"),
    TIME_OUT(9002, "请求超时"),
    OK(200, "请求通过"),
    NO(201, "请求不通过");
    private final Integer code;

    private final String message;

    public static ErrorCodeEnum getEnumByCode(Integer code) {
        ErrorCodeEnum[] enums = ErrorCodeEnum.values();
        for (ErrorCodeEnum statusEnum : enums) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum;
            }
        }
        return null;
    }
}
