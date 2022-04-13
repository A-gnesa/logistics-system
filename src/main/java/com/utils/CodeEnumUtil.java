package com.utils;

import com.enums.BaseCodeEnum;

/**
 * @Author 程子涵
 * @Date 2022/4/6
 */
public class CodeEnumUtil {
    public static <E extends Enum<?> & BaseCodeEnum> E codeOf(Class<E> enumClass, int code) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    private CodeEnumUtil() {
    }
}
