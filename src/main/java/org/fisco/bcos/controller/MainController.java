package org.fisco.bcos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//音乐区

@Controller
public class MainController {

    @RequestMapping("/search")
    public String Search(String musicName, String athuorName){
        String result = "0";
        return result;
    }

}
