package com.ixxus.poc.peerreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
    @RequestMapping("/")
    String index(){
        return "redirect:index.html";
    }
    
}
