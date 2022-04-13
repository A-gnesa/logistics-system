package com.enity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
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
    @NotBlank(message = "编码错误",groups = {Group.Update.class})
    private String no;

    @ApiModelProperty("库存名称")
    @NotBlank(message = "库存名称不能为空", groups = {Group.Insert.class})
    private String name;


    private Integer inventory;

    private Integer maxInventory;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
