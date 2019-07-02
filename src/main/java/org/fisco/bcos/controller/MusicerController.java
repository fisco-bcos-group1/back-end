package org.fisco.bcos.controller;

import org.fisco.bcos.function.Transfer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用于响应音乐人界面
 */
@Controller
public class MusicerController {
    String privateKey = "b83261efa42895c38c6c2364ca878f43e77f3cddbc922bf57d0d48070f79feb6";
    private Transfer transfer;

    public MusicerController() throws Exception {
        this.transfer = new Transfer(privateKey);
    }

    /**
     * 响应音乐人注册
     * @param name
     * @param id
     * @param location
     * @param phone
     * @param email
     * @throws Exception
     */
    @RequestMapping("/registerMusicer")
    public void RegisterMusicer(@RequestParam("name") String name,
                                @RequestParam("id") String id,
                                @RequestParam("location") String location,
                                @RequestParam("phone") String phone,
                                @RequestParam("email") String email)throws Exception{
        transfer.registerUser(name,id,location,phone,email);

    }
}
