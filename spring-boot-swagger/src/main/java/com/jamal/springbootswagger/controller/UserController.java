package com.jamal.springbootswagger.controller;

import com.jamal.springbootswagger.domain.User;
import com.jamal.springbootswagger.service.UserService;
import com.jamal.springbootswagger.utils.ResultDTO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@Api(tags = "用户管理", value = "用户管理")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户")
    @GetMapping(path = "/user")
    public ResultDTO findUser() {
        ResultDTO resultDTO = new ResultDTO();
        try {
            resultDTO.setSuccess(true);
            resultDTO.setModule(userService.findUser());
        } catch (Exception e) {
            logger.error(e.getMessage());
            resultDTO.setSuccess(false);
            resultDTO.setErrorCode("400");
            resultDTO.setErrorMsg(e.getMessage());
        }
        return resultDTO;
    }

    @ApiOperation(value = "新增用户")
    @PostMapping(path = "/user")
    public ResultDTO insertUser(@RequestBody User user) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            userService.insertUser(user);
            resultDTO.setSuccess(true);
        } catch (Exception e) {
            resultDTO.setSuccess(false);
            resultDTO.setErrorCode("400");
            resultDTO.setErrorMsg(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultDTO;
    }

    @PutMapping(path = "/user")
    @ApiOperation(value = "更新用户",notes = "更新用户信息")
    public ResultDTO updateUser(@RequestBody User user) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            userService.updateUser(user);
            resultDTO.setSuccess(true);
        } catch (Exception e) {
            resultDTO.setSuccess(false);
            resultDTO.setErrorCode("400");
            resultDTO.setErrorMsg(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultDTO;
    }

    @DeleteMapping(path = "/user/{id}")
    @ApiOperation(value = "删除用户", notes = "根据ID删除用户信息")
//    @ApiImplicitParams({
//            @ApiImplicitParam(value="用户id",name = "id",paramType="path")
//    })
    public ResultDTO deleteUser(@ApiParam(value = "用户id",name = "id") @PathVariable(value = "id") int id) {
        ResultDTO resultDTO = new ResultDTO();
        try {
            userService.deleteUser(id);
            resultDTO.setSuccess(true);
        } catch (Exception e) {
            resultDTO.setSuccess(false);
            resultDTO.setErrorCode("400");
            resultDTO.setErrorMsg(e.getMessage());
            logger.error(e.getMessage());
        }
        return resultDTO;
    }

    @DeleteMapping(path = "/user/ingorApi")
    @ApiIgnore(value = "我是别忽略的API接口，我将不会在Swagger上显示")
    public ResultDTO ignoreApi() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setSuccess(true);
        return resultDTO;
    }

}
