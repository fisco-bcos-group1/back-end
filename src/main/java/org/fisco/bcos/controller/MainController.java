package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Music;
import org.fisco.bcos.entity.Result;
import org.fisco.bcos.entity.User;
import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 响应音乐区，即index
 */

@RestController
public class MainController {

    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    //String privateKey = LoginController.getPrivateKey();
    //Transfer transfer = ContractService.getTransfer(privateKey);


    /**
     *搜索
     */
    @RequestMapping("/api/search")
    public Result Search(@RequestParam("mName") String mName,
                               @RequestParam("singer") String singer,
                                @RequestParam("privateKey") String privateKey){
        try {
            Transfer transfer = ContractService.getTransfer(privateKey);
            Music music = transfer.searchMusic(mName, singer);
            return new Result(1,"歌曲搜索成功",music);
        }catch(Exception e){
            e.printStackTrace();
            return new Result(0,"歌曲搜索失败");
        }
    }

    /**
     * 点击申请授权
     * 应该是网页跳转，没有数据交互
     */
//    @RequestMapping("/api/8")
//    public void Authorize(){
//
//    }

    /**
     * 响应确定申请授权
     * @param music mname # singer # recordTime # applyTime
     *              需要包含两个时间
     * @param to  即为该music的owner字段，即版权所有方的地址
     * @param info applicantName # phone # use # location # length # text # price
     * @return
     */

    @RequestMapping("/api/apply")
    public Result ConfirmAuthorize(@RequestParam("music") String music,
                                   @RequestParam("to") String to,
                                   @RequestParam("info") String info,
                                   @RequestParam("privateKey") String privateKey){
        try{
            Transfer transfer = ContractService.getTransfer(privateKey);
            transfer.registerNotice(to,music,info);
            return new Result(1,"提交申请授权成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(0,"提交申请授权失败");
        }
    }

}
