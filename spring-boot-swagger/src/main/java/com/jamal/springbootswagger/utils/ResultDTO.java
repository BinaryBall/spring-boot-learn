package com.jamal.springbootswagger.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "接口返回实体类")
public class ResultDTO<T> implements Serializable {

    @ApiModelProperty(value = "错误消息")
    private String errorMsg;

    @ApiModelProperty(value = "错误码")
    private String errorCode;

    @ApiModelProperty(value = "接口处理成功标识")
    private boolean success;

    @ApiModelProperty(value = "结果集")
    private T module;
}
