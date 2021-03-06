package com.enity;

import com.annotation.Phone;
import com.enums.OrderStateEnum;
import com.enums.TransportModeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
@Data
@Accessors(chain = true)
@ApiModel("订单类")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {
    private static final long serialVersionUID = 7870873988498281879L;

    private Integer id;
    @ApiModelProperty("订单编码")
    @NotBlank(message = "订单错误", groups = {Group.Update.class})
    private String no;

    @ApiModelProperty("始发地")
    @NotBlank(message = "始发地不能为空", groups = {Group.Insert.class})
    private String startingPoint;

    @ApiModelProperty("目的地")
    @NotBlank(message = "目的地不能为空", groups = {Group.Insert.class})
    private String destination;

    @ApiModelProperty("价格")
    @NotNull(message = "价格不能为空", groups = {Group.Insert.class})
    private BigDecimal price;

    @ApiModelProperty("收件人")
    @NotBlank(message = "收件人不能为空", groups = {Group.Insert.class})
    private String sender;

    @ApiModelProperty("收件人电话")
    @Phone
    @NotBlank(message = "收件人电话不能为空", groups = {Group.Insert.class})
    private String senderTel;

    @ApiModelProperty("寄件人")
    @NotBlank(message = "寄件人不能为空", groups = {Group.Insert.class})
    private String addressee;

    @ApiModelProperty("寄件人电话")
    @Phone
    @NotBlank(message = "寄件人电话不能为空", groups = {Group.Insert.class})
    private String addresseeTel;

    @ApiModelProperty("运输设备编码")
    private String transportNo;

    @ApiModelProperty("订单状态")
    private OrderStateEnum state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
