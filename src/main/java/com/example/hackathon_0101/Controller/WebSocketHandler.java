package com.example.hackathon_0101.Controller;

import com.example.hackathon_0101.Dto.ResultData;
import com.example.hackathon_0101.SocketConnector;
import com.google.gson.*;
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
import java.util.ArrayList;
import java.util.List;

@Component
public class WebSocketHandler extends TextWebSocketHandler {
    private WebSocketSession socketSession;
    private List<ResultData> resultDataList;
    protected Logger logger = LoggerFactory.getLogger(WebSocketHandler.class);

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
            socketSession.sendMessage(new TextMessage(data));
        } catch (IOException e) {
            // Handle exception
        }
    }
    //서버로부터 받은 메시지 처리
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Gson gson = new Gson();
        ArrayList list = gson.fromJson(message.getPayload(), ArrayList.class);
        String str = list.get(0).toString();
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(str);
        List<ResultData> dataList = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject object = (JsonObject) jsonArray.get(i);
            String title = object.get("title").getAsString();
            String link = object.get("link").getAsString();
            ResultData resultData = new ResultData(title, link);
            dataList.add(resultData);
            System.out.println(title+" "+link);

        }
        resultDataList=dataList;
    }
    public List<ResultData> getResult(){
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