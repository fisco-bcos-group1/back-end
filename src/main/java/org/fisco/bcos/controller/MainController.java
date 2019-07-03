package org.fisco.bcos.controller;

import org.fisco.bcos.entity.Result;
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
    String privateKey = LoginController.getPrivateKey();
    Transfer transfer = ContractService.getTransfer(privateKey);


    /**
     *搜索
     */
    @RequestMapping("/")
    public void Search(@RequestParam("musicName") String musicName,
                       @RequestParam("singer") String singer){

    }

    /**
     * 点击申请授权
     */
    @RequestMapping("/")
    public void Authorize(){

    }

    /**
     * 点击确定申请授权
     */
    @RequestMapping("/")
    public Result ConfirmAuthorize(@RequestParam("music") String music,
                                   @RequestParam("singer") String singer,
                                   @RequestParam("")){
        return new Result<String>(1,"授权成功");
    }

}
