package com.enity;

import com.annotation.Phone;
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
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
@Data
@ApiModel("用户")
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

    private static final long serialVersionUID = -3337995730223973484L;

    private Integer id;
    @ApiModelProperty("用户编码")
    @NotBlank(message = "编码为空", groups = {Group.Update.class})
    private String no;

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空", groups = {Group.Insert.class})
    private String name;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空", groups = {Group.Insert.class,Group.Login.class})
    private String password;

    @Phone(groups = {Group.Insert.class})
    @ApiModelProperty("电话号")
    @NotBlank(message = "电话不能为空", groups = {Group.Insert.class,Group.Login.class})
    private String tel;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;
}
