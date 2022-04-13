package com.exception;


import com.enums.ErrorCodeEnum;

/**
 * @Author 赵官乔
 * @Date 2022/3/19
 */

public class ErrorCodeException extends RuntimeException {
    private static final long serialVersionUID = -7638041501183925225L;
    /**
     * 错误代码
     */
    private Integer code;

    public ErrorCodeException(ErrorCodeEnum errorCode, String msg) {
        super(msg);
        this.code = errorCode.getCode();
    }

    public ErrorCodeException(int errorCode, String msg) {
        super(msg);
        this.code = errorCode;
    }

    public ErrorCodeException(ErrorCodeEnum errorCode) {
        super(errorCode.getMessage());
        this.code = errorCode.getCode();
    }

    public ErrorCodeException(String msg) {
        super(msg);
        this.code = ErrorCodeEnum.NO.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
