package com.jamal.httpclientauth.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaoxiang
 * @title: WebController
 * @projectName httpclient-auth
 * @description: TODO
 * @date 2019/9/313:53
 */
@RestController
public class WebController {

    @RequestMapping(path = "/hello")
    public String hello(){
        return "验证通过";
    }
}
