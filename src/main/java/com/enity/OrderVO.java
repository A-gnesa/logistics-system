package com.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Date 2022/5/15 8:26 PM
 * @Author 赵冠乔
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("订单视图显示实体类")
public class OrderVO extends Order implements Serializable {

    private static final long serialVersionUID = 3956759507217629143L;

    @ApiModelProperty("运输设备")
    Equipment equipment;

    public OrderVO(Order order) {
        setNo(order.getNo());
        setStartingPoint(order.getStartingPoint());
        setDestination(order.getDestination());
        setPrice(order.getPrice());
        setSender(order.getSender());
        setSenderTel(order.getSenderTel());
        setAddressee(order.getAddressee());
        setAddresseeTel(order.getAddresseeTel());
        setState(order.getState());
    }
}
