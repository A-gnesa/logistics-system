package com.enity;

import com.enums.EquipmentStateEnum;
import com.enums.TransportModeEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Date 2022/5/15 1:35 PM
 * @Author 赵冠乔
 */
@Data
@Accessors(chain = true)
@ApiModel("设备类")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Equipment implements Serializable {
    private static final long serialVersionUID = 3560066914253005697L;

    private Integer id;

    @ApiModelProperty("设备编码")
    @NotBlank(message = "设备信息错误", groups = {Group.Update.class})
    private String no;

    @ApiModelProperty("城市名称")
    @NotBlank(message = "城市名称不能为空", groups = {Group.Insert.class})
    private String city;

    @ApiModelProperty("设备名称")
    @NotBlank(message = "设备名称不能为空", groups = {Group.Insert.class})
    private String name;

    @ApiModelProperty("运输方式")
    @NotNull(message = "运输方式不能为空", groups = {Group.Insert.class})
    private TransportModeEnum mode;

    @ApiModelProperty("设备状态")
    EquipmentStateEnum state;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
