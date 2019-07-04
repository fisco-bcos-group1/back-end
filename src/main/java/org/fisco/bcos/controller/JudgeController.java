package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Music;
import org.fisco.bcos.entity.RecordInformation;
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
    //String privateKey = LoginController.getPrivateKey();
    //Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     * 响应申请认证仲裁机构
     */
    @RequestMapping("/api/2")
    public Result Register(@RequestParam("name") String name,
                           @RequestParam("location") String location,
                           @RequestParam("phone") String phone,
                           @RequestParam("email") String email,
                           @RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.registerJudge(name, "", location, phone, email);
            return new Result(1,"仲裁机构认证成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"机构仲裁认证失败");
        }
    }

    /**
     * 版权查询
     * 响应点击搜索按钮
     */
    @RequestMapping("/api/3")
    public Result SearchingRecord(@RequestParam("musicName") String musicName,
                                                     @RequestParam("singer") String singer,
                                                     @RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            Music music = transfer.searchMusic(musicName, singer);
            User user = transfer.getUserByAddress(music.getOwner());
            RecordInformation recordInformation = new RecordInformation(music,user);
            return new Result(1,"搜索版权信息成功",recordInformation);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"搜索版权信息失败");
        }
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
    @RequestMapping("/api/4")
    public Result JudgeInformation(@RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            User user = transfer.getUser();
            return new Result(1,"机构信息返回成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"机构信息返回失败");
        }
    }
}
