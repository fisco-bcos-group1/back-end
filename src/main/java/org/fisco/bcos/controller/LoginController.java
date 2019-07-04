package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
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
    @RequestMapping("/api/5")
    public List<String> Register(@RequestParam("name") String name,
                                 @RequestParam("phone") String phone){
        return CreateUser.createRomdonUser();
    }

    /**
     * 响应点击登陆
     */
    // 这里没有对私钥正确性进行检测
    @RequestMapping("/api/6")
    public Result Login(@RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            User user = transfer.getUser();
            return new Result<User>(1,"登陆成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,e.getMessage());
        }
    }

}
