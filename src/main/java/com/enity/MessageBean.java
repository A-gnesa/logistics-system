package com.enity;

import com.enums.ErrorCodeEnum;
import com.exception.ErrorCodeException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵官乔
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageBean implements Serializable {
    private static final long serialVersionUID = 7192766535561421181L;
    /**
     * 响应信息
     */
    private String msg;
    /**
     * 响应数据
     */
    private Object data;
    /**
     * 响应码
     */
    private Integer code;

    public MessageBean(ErrorCodeEnum errorCode, Object data, String errorMsg) {
        this.code = errorCode.getCode();
        this.data = data;
        this.msg = errorMsg;
    }

    public MessageBean(ErrorCodeEnum errorCode, Object data) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
        this.data = data;
    }

    public MessageBean(ErrorCodeEnum errorCode, String errorMsg) {
        this.code = errorCode.getCode();
        this.msg = errorMsg;
    }

    public MessageBean(ErrorCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }

    public MessageBean(ErrorCodeException e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
    }

    public static MessageBean fail(String errorMsg) {
        return new MessageBean(ErrorCodeEnum.NO, errorMsg);
    }

    public static MessageBean fail() {
        return fail("操作失败");
    }

    public static MessageBean success(Object data, String errorMsg) {
        return new MessageBean(ErrorCodeEnum.OK, data, errorMsg);
    }

    public static MessageBean success() {
        MessageBean messageBean = new MessageBean();
        messageBean.setCode(ErrorCodeEnum.OK.getCode());
        messageBean.setMsg("操作成功");
        return messageBean;
    }

    public static boolean isSuccess(MessageBean result) {
        return result != null && ErrorCodeEnum.OK.getCode().equals(result.getCode());
    }

    public static MessageBean success(Object data) {
        return new MessageBean(ErrorCodeEnum.OK, data);
    }

    public static MessageBean success(String errorMsg) {
        return new MessageBean(ErrorCodeEnum.OK, errorMsg);
    }
}
