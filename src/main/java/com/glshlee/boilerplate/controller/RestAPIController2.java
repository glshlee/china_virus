package com.glshlee.boilerplate.controller;

import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

@RestController
public class RestAPIController2 {

   static HttpComponentsClientHttpRequestFactory factory;
   static RestTemplate restTemplate;

   public RestAPIController2(){
      factory = new HttpComponentsClientHttpRequestFactory();
      factory.setReadTimeout(5000);
      factory.setConnectionRequestTimeout(3000);
      HttpClient httpClient = HttpClientBuilder.create()
              .setMaxConnTotal(100)
              .setMaxConnPerRoute(5)
              .build();
      factory.setHttpClient(httpClient);
      restTemplate = new RestTemplate(factory);
   }
   @GetMapping("/apitest2/{page}")
   public JSONObject apiTest(@PathVariable(value = "page",required = false) String page){
      String url ="https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page={whatPage}";

      String value = page;
      Map<String,String> vars = Collections.singletonMap("whatPage",value);
      JSONObject obj = restTemplate.getForObject(url,JSONObject.class,vars);
      System.out.println(obj);

      return obj;
   }

   @GetMapping("/apitest3")
   public void getExcel(){
      String url = "https://www.mohw.go.kr/react/popup_200128.html";
//      restTemplate.getForObject(url,);
   }

}
