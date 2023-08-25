package com.example.hackathon_0101.Controller;


import com.example.hackathon_0101.Dto.ResultDto;
import com.example.hackathon_0101.Dto.SearchDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@Controller
public class SearchController{
    private static SearchDto search;
    private final WebSocketHandler webSocketHandler;
    @Autowired
    public SearchController(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @ResponseBody
    @GetMapping("/search") //frontend에서 검색 데이터 받아옴
    public ResponseEntity<List<ResultDto>> Search(@RequestParam String conference, String year, String keyword) throws InterruptedException { //@RequestParam String conference, String year,String keyword
        //ResponseEntity<List<ResultDto>>
        String s = "";
        s+=conference+" ";
        s+=year+" ";
        s+=keyword;
        System.out.println(s);
        //System.out.println(searchData.getConference());
        //System.out.println(searchData.getKeyword());
        //System.out.println(searchData.getYear());
        webSocketHandler.sendDataViaWebSocket(s);
        Thread.sleep(1000);
        List<ResultDto> result = webSocketHandler.getResult();
        System.out.println(result.size());
        if (result.size() == 5) {
            System.out.println("OK");
            return ResponseEntity.ok(result);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/result")
    public ResponseEntity<List<ResultDto>> getResult() {
        List<ResultDto> result = webSocketHandler.getResult();
        System.out.println(result);
        if (result != null) {
            System.out.println("OK");
            return ResponseEntity.ok(result);
        }
        else {
            System.out.println("Error");
            return ResponseEntity.notFound().build();
        }
    }

    public SearchDto getSearch(){
        return search;
    }

}