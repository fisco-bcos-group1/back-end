package org.fisco.bcos.controller;

import org.fisco.bcos.function.Transfer;
import org.fisco.bcos.service.ContractService;
import org.springframework.stereotype.Controller;

/**
 * 响应音乐区，即index
 */

@Controller
public class MainController {

    //String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    String privateKey = LoginController.getPrivateKey();
    Transfer transfer = ContractService.getTransfer(privateKey);

    /**
     *响应点击搜索

    @RequestMapping("/search")
    public Music Search(String musicName, String athuorName){
        String musicname = transfer
    }

    */
}
