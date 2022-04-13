package com.enums;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
public enum TransportModeEnum implements BaseCodeEnum {
    /**
     * 陆运
     */
    LAND(0),
    /**
     * 空运
     */
    AIRLIFT(1);

    private final Integer code;

    TransportModeEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
