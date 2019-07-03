package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Result;
import org.fisco.bcos.service.CreateUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用于用户注册页面
 */
@RestController
public class LoginController {

    // 用户私钥
    private static String privateKey;

    public static String getPrivateKey() {
        return privateKey;
    }

    /**
     * 响应点击注册按钮
     */
    @RequestMapping("/")
    public List<String> Register(@RequestParam("name") String name,
                                 @RequestParam("phone") String phone){
        return CreateUser.createRomdonUser();
    }

    /**
     * 响应点击登陆
     */
    // 这里没有对私钥正确性进行检测
    @RequestMapping("/")
    public Result Login(@RequestParam("privateKey") String privatekey){
        privateKey = privatekey;
        return new Result(1,"登陆成功");
    }

}
