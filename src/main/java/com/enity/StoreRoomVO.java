package com.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Date 2022/5/15 3:55 PM
 * @Author 赵冠乔
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreRoomVO extends StoreRoom implements Serializable {
    private static final long serialVersionUID = 6395284626884756300L;

    private String managerName;

    public StoreRoomVO(StoreRoom storeRoom) {
        setNo(storeRoom.getNo());
        setName(storeRoom.getName());
        setInventory(storeRoom.getInventory());
        setMaxInventory(storeRoom.getMaxInventory());
        setCreateTime(storeRoom.getCreateTime());
        setUpdateTime(storeRoom.getUpdateTime());
    }
}
