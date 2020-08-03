package com.lcal.chinavirus.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.h2.util.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

@RestController
@Slf4j
public class NaverRestAPIMapController {
//   static final Logger logger = LoggerFactory.getLogger(NaverRestAPIMapController.class);
   static HttpComponentsClientHttpRequestFactory factory;
   static RestTemplate restTemplate;
   static final String resource = "/application-naver.properties";
   static Properties properties;


   public NaverRestAPIMapController() {
      factory = new HttpComponentsClientHttpRequestFactory();
      factory.setReadTimeout(5000);
      factory.setConnectionRequestTimeout(3000);
      HttpClient httpClient = HttpClientBuilder.create().setMaxConnTotal(100).setMaxConnPerRoute(5).build();
      factory.setHttpClient(httpClient);
      restTemplate = new RestTemplate(factory);
      properties = new Properties();
   }

   @GetMapping("/apitest2/{page}")
   public JSONObject apiTest(@PathVariable(value = "page", required = false) String page) {
      String url = "https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page={whatPage}";

      String value = page;
      Map<String, String> vars = Collections.singletonMap("whatPage", value);
      JSONObject obj = restTemplate.getForObject(url, JSONObject.class, vars);
      System.out.println(obj);

      return obj;
   }

   @GetMapping("/whatlocation")
   public String getLocationFromXYCoordinate(@RequestParam(value="location",
                                 defaultValue = "동작구") String location ){
//      log.warn("<<<<<<<<<<<  get Location  >>>>>>>>>>>>.");
       log.warn("test");
       
      String apiURL= "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query="+location;

      HttpHeaders headers = new HttpHeaders();
      headers.set("X-NCP-APIGW-API-KEY-ID", "9bt34yijp5");
      headers.set("X-NCP-APIGW-API-KEY", "yrE9lyniWQaEnHhSMd6htVRD1ackNYqKakvzSDY1");

      HttpEntity entity = new HttpEntity(headers);

      ResponseEntity<String> response = restTemplate.exchange(apiURL, HttpMethod.GET,entity,String.class);

      String body = response.getBody();
      System.out.println(body);

//      log.warn("<<<<<<<<<<<  out Location  >>>>>>>>>>>>.");
      return body;
   }
}
