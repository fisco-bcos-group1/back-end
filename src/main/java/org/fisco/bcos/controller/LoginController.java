package org.fisco.bcos.controller;

import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.fisco.bcos.service.CreateUser;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用于用户注册页面
 */
@RestController
@Slf4j
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
    public Result Register(@RequestBody Map<String,Object> request){
        String name = (String)request.get("name");
        String phone = (String)request.get("phone");
        log.info("name:" + name);
        log.info("phone:" + phone);
        try{
            List<String> temp = CreateUser.createRomdonUser();
            Transfer transfer = ContractService.getTransfer(temp.get(0));
            transfer.registerUser(name,phone);
            return new Result(1,"用户注册成功", temp);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"用户注册失败");
        }
    }

    /**
     * 响应点击登陆
     */
    // 这里没有对私钥正确性进行检测
    @RequestMapping("/api/6")
    public Result Login(@RequestBody Map<String,String> request){
        String privateKey = request.get("privateKey");
        log.info("privateKey:" + privateKey);
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            User user = transfer.getUser();
            log.info(user.getName());
            return new Result(1,"登陆成功", user);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0, e.getMessage());
        }
    }

}
