//package com.example.hackathon_0101;
//
//import com.example.hackathon_0101.Dto.SearchData;
//import jakarta.websocket.*;
//import jakarta.websocket.server.ServerEndpoint;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.io.IOException;
//
//@ServerEndpoint("/websocket")
//public class WebSocketServer {
//
//    protected Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
//
//    @OnMessage
//    public void handleMessage(Session session, String message) throws IOException, IOException {
//        logger.info("Message received from client {}", message);
//        session.getBasicRemote().sendText("Received : " + new StringBuilder(message));
//    }
//
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config) {
//        logger.info("Socket has opened with Session {} \n EndpointConfig {}", session, config);
//    }
//
//    @OnError
//    public void errorOcured(Throwable throwable) throws IOException {
//        logger.error("Error occured on socket connection", throwable);
//    }
//
//    @OnClose
//    public void onClose(CloseReason closeReason) {
//        logger.info("Socket has closed. Reason {}", closeReason);
//    }
//}
