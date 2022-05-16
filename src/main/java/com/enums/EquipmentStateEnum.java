package com.enums;

/**
 * @Date 2022/5/15 4:40 PM
 * @Author 赵冠乔
 */
public enum EquipmentStateEnum implements BaseCodeEnum {
    /**
     * 闲置
     */
    IDLE(0),
    /**
     * 运输中
     */
    TRANSPORT(1);

    private final Integer code;

    EquipmentStateEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }
}
