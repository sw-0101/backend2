package com.example.hackathon_0101;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;


@Configuration
public class SocketConnector {
    protected Logger logger = (Logger) LoggerFactory.getLogger(SocketConnector.class);

    @Lazy
    @Autowired
    private WebSocketHandler handler;

    private WebSocketConnectionManager manager;


    public void establishSocket() {
        logger.info("Establishing socket...");
    }

    public void reconnect() {
        manager.stop();
        manager.start();
    }

    @Bean
    public WebSocketConnectionManager wsConnectionManager() {
        manager = new WebSocketConnectionManager(client(), handler, "ws://localhost:9998");
        manager.setAutoStartup(true);
        return manager;
    }

    @Bean
    public StandardWebSocketClient client() {
        return new StandardWebSocketClient();
    }


}