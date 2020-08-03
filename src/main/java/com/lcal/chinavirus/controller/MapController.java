package com.lcal.chinavirus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {

    @GetMapping("/start")
    public String mapInfo(Model model){
        System.out.println("info come!!");
        return "MapInfoFromClient";
    }

}
