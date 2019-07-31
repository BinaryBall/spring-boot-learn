package com.jamal.springbootswagger.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "用户实体类")
public class User implements Serializable {

    @ApiModelProperty(value = "业务主键", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private int id;

    @ApiModelProperty(value = "名称", required = true)
    private String name;

    @ApiModelProperty(value = "手机号码", required = true)
    private String mobile;

    @ApiModelProperty(value = "电子邮箱", required = true)
    private String email;
}
