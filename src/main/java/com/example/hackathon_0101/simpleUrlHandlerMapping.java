//package com.example.hackathon_0101;
//
//import com.example.hackathon_0101.Controller.SearchController;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class simpleUrlHandlerMapping {
//    @Bean
//    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
//        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
//
//        Map<String, Object> urlMap = new HashMap<>();
//        urlMap.put("/search", welcome());
//        simpleUrlHandlerMapping.setUrlMap(urlMap);
//
//
//        return simpleUrlHandlerMapping;
//    }
//
//    @Bean
//    public SearchController welcome(){
//        return new SearchController();
//    }
//}
