package com.lcal.chinavirus.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class Covid19MaskStoreControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void givenValidRequest_WhenGetAllMaskStore_thenReturnResponse() throws Exception {
        // given

        // when
        ResultActions resultActions = mvc.perform(get("/api/covid19/v1/maskstore")).andDo(print());

        // then
        resultActions.andExpect(status().isOk()).andExpect(jsonPath("$").isArray());
    }
}