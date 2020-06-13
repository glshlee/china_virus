package com.lcal.chinavirus.controller;

import java.util.List;

import com.lcal.chinavirus.entity.MaskStore;
import com.lcal.chinavirus.service.Covid19MaskStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/covid19/v1/maskstore")
public class Covid19MaskStoreController {
    
    @Autowired
    private Covid19MaskStoreService maskStoreSerivce;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<MaskStore> getAllMaskStore() throws Exception {
        return maskStoreSerivce.getAllMaskStore();
    }

}