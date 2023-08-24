package com.example.hackathon_0101;

import com.example.hackathon_0101.Controller.SearchController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.frame.Jackson2SockJsMessageCodec;

import java.io.*;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.logging.Logger;

@SpringBootApplication
@Configuration
@EnableWebSocket
public class Hackathon0101Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Hackathon0101Application.class, args);
    }
//        @Override
//        protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//            return application.sources(Hackathon0101Application.class);
//        }
//
//        /**
//         * This is required for connecting with websocket endpoint. As websocket is annotated with
//         * serverendpoint
//         *
//         * @return
//         */
//        @Bean
//        public ServerEndpointExporter serverEndpointExporter() {
//            return new ServerEndpointExporter();
//        }
//
//        @Bean
//        public WebSocketServer webSocketEndpoint() {
//            return new WebSocketServer();
//        }

//    @Bean
//    public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
//        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
//
//        Map<String, Object> urlMap = new HashMap<>();
//        urlMap.put("/simpleUrlWelcome", welcome());
//        simpleUrlHandlerMapping.setUrlMap(urlMap);
//
//        return simpleUrlHandlerMapping;
//    }
//
//    @Bean
//    public SearchController welcome(){
//        return new SearchController();
//    }

}



