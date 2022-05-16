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
 * @Date 2022/5/15 9:06 PM
 * @Author 赵冠乔
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel("订单视图显示实体类")
public class CityVO extends City implements Serializable {
    private static final long serialVersionUID = -3537713598961604994L;

    @ApiModelProperty("车数量")
    private Integer carNumber;

    @ApiModelProperty("飞机数量")
    private Integer airNumber;

    public CityVO(City city) {
        setName(city.getName());
        setCreateTime(city.getCreateTime());
        setUpdateTime(city.getUpdateTime());
    }
}
