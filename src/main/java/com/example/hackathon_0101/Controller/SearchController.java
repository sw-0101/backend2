package com.example.hackathon_0101.Controller;


import com.example.hackathon_0101.Dto.ReferenceDto;
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
import java.util.Map;

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
        String s = "s" +conference + " " + year + " " + keyword;    //search flag
        webSocketHandler.sendDataViaWebSocket(s);
        //Thread.sleep(8000);
        int size = 0;
        List<ResultDto> result = null;
        while(webSocketHandler.getResult().size()!=5){
            result = webSocketHandler.getResult();
            size = webSocketHandler.getResult().size();
        }
        return ResponseEntity.ok(result);
//        List<ResultDto> result = webSocketHandler.getResult();
//        if (result.size() == 5) {
//            log.info("SUCCESS Get Mapping /search");
//            return ResponseEntity.ok(result);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping("/result")
    public ResponseEntity<ReferenceDto> getResult(@RequestBody Map<String,String> pickTitle ) throws InterruptedException {
        String title = pickTitle.get("pickTitle");
        //pickTitle을 줘서 레퍼런스 논문들을 얻어와야 함
        webSocketHandler.sendDataViaWebSocket("r" + title); //result flag
        Thread.sleep(8000);

        ReferenceDto referenceDTO = new ReferenceDto();
        referenceDTO.setParent1("Layer Normalization");
        referenceDTO.setParent2("Segment Anything");
        referenceDTO.setChild1("Generating Sequences With Recurrent Neural Networks");
        referenceDTO.setChild2("Batch Normalized Recurrent Neural Networks");
        referenceDTO.setChild3("BEiT: BERT Pre-Training of Image Transformers");
        referenceDTO.setChild4("On the Opportunities and Risks of Foundation Models");
//        while(referenceDTO==null){
//            referenceDTO = webSocketHandler.getReferenceDto();
//        }
        return ResponseEntity.ok(referenceDTO);
//        if(!referenceDTO.getChild4().isEmpty()){
//            log.info("SUCCESS POST Mapping /result");
//            return ResponseEntity.ok(referenceDTO);
//        }else return ResponseEntity.notFound().build();
    }

    public SearchDto getSearch() {
        return search;
    }

}