package com.enums;

/**
 * @Author 赵冠乔
 * @Date 2022/4/11
 */
public enum OrderStateEnum implements BaseCodeEnum{
    /**
     * 创建
     */
    CREATE(0),
    /**
     * 运输中
     */
    SHIPMENTS(1),
    /**
     * 已收货
     */
    RECEIVED(2);

    private final Integer code;

    OrderStateEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
