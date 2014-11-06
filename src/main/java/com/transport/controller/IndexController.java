package com.transport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    
    @RequestMapping("index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String defaultIndex() {
        return "index";
    }
}
