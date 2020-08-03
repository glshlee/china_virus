package com.lcal.chinavirus.controller;

import com.lcal.chinavirus.service.HospitalService;
import org.h2.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController{

    @Autowired
    HospitalService hospitalService;

    @GetMapping("/hello")
    public String FirstMainMiew(Model model){
        model.addAttribute("message", "Hi, you guys");
        return "main"; 
    } 
    
    @GetMapping({"/excel", "/Excel"})
    public String excelLoad(Model model){

        //// TODO: 2020-04-07
        //1. call  hospitals file from server
        String result =  hospitalService.getExcelFileFromServer();


        //2. get hospitls JSONObject format
        JSONObject jsondata = hospitalService.excelToJsonFormat();

        String test ="haha";
        String test2 ="milion";
        model.addAttribute("test",test);
        model.addAttribute("test",test);
        model.addAttribute("jsondata",jsondata);
        return "ExcelFileImportButtonTest";
    }
}