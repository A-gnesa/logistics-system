package com.enity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author 赵冠乔
 * @Date 2022/4/10
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -3337995730223973484L;

    private Integer id;

    private String no;

    private String name;

    private String password;

    private String tel;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
