package com.example.hackathon_0101.Controller;


import com.example.hackathon_0101.Dto.ResultDto;
import com.example.hackathon_0101.Dto.SearchDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@Slf4j
public class SearchController {
    private static SearchDto search;
    private final WebSocketHandler webSocketHandler;

    @Autowired
    public SearchController(WebSocketHandler webSocketHandler) {
        this.webSocketHandler = webSocketHandler;
    }

    @ResponseBody
    @GetMapping("/search") //frontend에서 검색 데이터 받아옴
    public ResponseEntity<List<ResultDto>> Search(@RequestParam String conference, String year, String keyword) throws InterruptedException { //@RequestParam String conference, String year,String keyword
        String s = "s" +conference + " " + year + " " + keyword;
        webSocketHandler.sendDataViaWebSocket(s);
        Thread.sleep(1000);
        List<ResultDto> result = webSocketHandler.getResult();
        if (result.size() == 5) {
            log.info("SUCCESS Get Mapping /search");
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/result")
    public void getResult(@RequestBody String pickTitle ) {
        //pickTitle을 줘서 레퍼런스 논문들을 얻어와야 함
        webSocketHandler.sendDataViaWebSocket(pickTitle);


    }

    public SearchDto getSearch() {
        return search;
    }

}