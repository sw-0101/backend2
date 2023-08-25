package com.example.hackathon_0101.Controller;


import com.example.hackathon_0101.Dto.ResultData;
import com.example.hackathon_0101.Dto.SearchData;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
public class SearchController{
    private static SearchData search;
    private final WebSocketHandler webSocketHandler;
    @Autowired
    public SearchController(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @ResponseBody
    @GetMapping("/search") //frontend에서 검색 데이터 받아옴
    public String Search(@RequestParam String conference, String year, String keyword) { //@RequestParam String conference, String year,String keyword
        String s = "";
        s+=conference+" ";
        s+=year+" ";
        s+=keyword;
        System.out.println(s);
        //System.out.println(searchData.getConference());
        //System.out.println(searchData.getKeyword());
        //System.out.println(searchData.getYear());
        webSocketHandler.sendDataViaWebSocket(s);
        return s;
    }

    @ResponseBody
    @PostMapping("/search2")
    public void SearchResult(@RequestBody HashMap<String, Object> map) { //Map<String, Object>
        System.out.println(map);
    }

    @GetMapping("/result")
    public ResponseEntity<List<ResultData>> getResult() {
        List<ResultData> dataList = webSocketHandler.getResult();
        if (dataList != null) return ResponseEntity.ok(dataList);
        else return ResponseEntity.notFound().build();
    }

    public SearchData getSearch(){
        return search;
    }

}