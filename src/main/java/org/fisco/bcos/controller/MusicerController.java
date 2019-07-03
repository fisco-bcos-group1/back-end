package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Result;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于响应音乐人界面
 */
@RestController
public class MusicerController {
    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    String privateKey = LoginController.getPrivateKey();
    Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     * 响应音乐人注册
     * @param name
     * @param id
     * @param location
     * @param phone
     * @param email
     * @throws Exception
     */
    @RequestMapping("/")
    public Result<String> RegisterMusican(@RequestParam("name") String name,
                                  @RequestParam("id") String id,
                                  @RequestParam("location") String location,
                                  @RequestParam("phone") String phone,
                                  @RequestParam("email") String email){
        try{
            transfer.registerMusician(name,phone,id,location,email);
            return new Result<String>(1,"音乐人注册成功",null);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<String>(0,"音乐人注册失败",null);
        }
    }
}
