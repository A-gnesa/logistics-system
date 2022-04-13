package com.enity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
@Data
@Accessors(chain = true)
@ApiModel("库存类")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreRoom implements Serializable {
    private static final long serialVersionUID = -9109004815183774889L;

    private Integer id;
    @ApiModelProperty("库存编码")
    @NotBlank(message = "编码为空", groups = {Group.Update.class})
    private String no;

    @ApiModelProperty("库存名称")
    @NotBlank(message = "库存名称不能为空", groups = {Group.Insert.class})
    private String name;

    @Min(value = 0, message = "库存数量最小为零", groups = {Group.Insert.class})
    @Max(value = 999999999999999999L, message = "数量过大", groups = {Group.Insert.class})
    @NotNull(message = "库存数量不能为空", groups = {Group.Insert.class})
    @ApiModelProperty("现有库存数量")
    private Integer inventory;

    @Min(value = 0, message = "最大库存数量最小为零", groups = {Group.Insert.class})
    @Max(value = 999999999999999999L, message = "数量过大", groups = {Group.Insert.class})
    @NotNull(message = "最大库存数量库存数量不能为空", groups = {Group.Insert.class})
    @ApiModelProperty("最大库存数量")
    private Integer maxInventory;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

}
