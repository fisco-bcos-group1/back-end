package org.fisco.bcos.controller;

import org.fisco.bcos.entity.MusicInformation;
import org.fisco.bcos.function.Transfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 响应音乐区，即index
 */

@Controller
public class MainController {

    String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    private Transfer transfer;

    public MainController() throws Exception {
        this.transfer = new Transfer(privateKey);
    }

    /**
     *响应点击搜索

    @RequestMapping("/search")
    public MusicInformation Search(String musicName, String athuorName){
        String musicname = transfer
    }

    */
}
