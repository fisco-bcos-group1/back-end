package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.fisco.bcos.service.CreateUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JudgeController {
    String privateKey = LoginController.getPrivateKey();
    Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     * 响应申请认证仲裁机构
     */
    @RequestMapping("/")
    public Result Register(@RequestParam("name") String name,
                           @RequestParam("location") String location,
                           @RequestParam("phone") String phone,
                           @RequestParam("email") String email){
        try{
            transfer.registerJudge(name, "", location, phone, email);
            return new Result(1,"仲裁机构认证成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"机构仲裁认证失败");
        }
    }

    /**
     * 版权查询
     */
    @RequestMapping("/")
    public void SearchingRecord(@RequestParam("musicName") String musicName,
                                @RequestParam("singer") String singer){


    }

    /**
     * 历史记录
     */
    @RequestMapping("/")
    public void SearchHistory(){

    }

    /**
     * 机构信息
     */
    @RequestMapping("/")
    public Result<User> JudgeInformation(){
        try{
            User user = transfer.getUser();
            return new Result<User>(1,"机构信息返回成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"机构信息返回失败");
        }
    }
}
