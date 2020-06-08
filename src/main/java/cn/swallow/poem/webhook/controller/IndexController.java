package cn.swallow.poem.webhook.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author swallow
 * @create 2020/6/8
 * @description
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping("/test")
    public String testOK(){
        return "test ok V2";
    }


}
