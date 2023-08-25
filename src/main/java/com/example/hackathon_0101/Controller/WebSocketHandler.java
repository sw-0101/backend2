package com.example.hackathon_0101.Controller;

import com.example.hackathon_0101.Dto.ResultDto;
import com.example.hackathon_0101.SocketConnector;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private WebSocketSession socketSession;
    private List<ResultDto> resultDataList;
    protected Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

    public ResultDto resultDto;

    @Lazy
    @Autowired
    private SocketConnector connector;

    //연결된 후 메시지 전송
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        socketSession= session;
    }
    public void sendDataViaWebSocket(String data) {
        try {
            resultDataList = new ArrayList<>();
            socketSession.sendMessage(new TextMessage(data));
        } catch (IOException e) {
            // Handle exception
        }
    }
    //서버로부터 받은 메시지 처리
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String msg = message.getPayload();
        System.out.println(msg);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(msg);
        //System.out.println(jsonNode);
        JsonNode titleNode = jsonNode.get("Title");
        JsonNode linkNode = jsonNode.get("Link");
        String[] titles = objectMapper.convertValue(titleNode, String[].class);
        String[] links = objectMapper.convertValue(linkNode, String[].class);
        resultDataList=new ArrayList<>();
        for(int i=0;i<5;i++){
            resultDataList.add(new ResultDto(titles[i],links[i] ));
        }
        System.out.println("result" + resultDataList.size());
    }
    public List<ResultDto> getResult(){
        return resultDataList;
    }
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        if (status.getCode() == 1006 || status.getCode() == 1011 || status.getCode() == 1012) {
            connector.reconnect();
        }
    }
}

