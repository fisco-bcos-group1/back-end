package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Music;
import org.fisco.bcos.entity.RecordInformation;
import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.fisco.bcos.service.CreateUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class JudgeController {
    //String privateKey = LoginController.getPrivateKey();
    //Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     * 响应申请认证仲裁机构
     */
    @RequestMapping("/api/judgeapply")
    public Result Register(@RequestBody Map<String,Object> request){
        try{
            String name = (String)request.get("name");
//            String id = (String)request.get("id");
            String location = (String)request.get("location");
            String phone = (String)request.get("phone");
            String email = (String)request.get("email");
            String privateKey = (String)request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.registerJudge(name, phone,"", location, email);
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
    @RequestMapping("/api/judgesearch")
    public Result SearchingRecord(@RequestBody Map<String,Object> request){
        try{
            String musicName = (String)request.get("musicName");
            String singer = (String)request.get("singer");
            String privateKey = (String)request.get("privateKey");
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
    @RequestMapping("/api/judge/history")
    public void SearchHistory(){

    }

    /**
     * 机构信息
     */
    @RequestMapping("/api/judge/info")
    public Result JudgeInformation(@RequestBody Map<String,String> request){
        try{
            String privateKey = request.get("privateKey");
            Transfer transfer = ContractService.getTransfer(privateKey);
            User user = transfer.getUser();
            return new Result(1,"机构信息返回成功",user);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"机构信息返回失败");
        }
    }
}
