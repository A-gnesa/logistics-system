package com.enity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Date 2022/5/15 1:43 PM
 * @Author 赵冠乔
 */
@Data
@Accessors(chain = true)
@ApiModel("城市类")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class City implements Serializable {

    private static final long serialVersionUID = -5019032819125843551L;

    private Integer id;

    @ApiModelProperty("城市名称")
    @NotBlank(message = "城市名称不能为空", groups = {Group.Insert.class})
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
