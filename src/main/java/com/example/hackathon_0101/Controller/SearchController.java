package com.example.hackathon_0101.Controller;


import com.example.hackathon_0101.Dto.ResultData;
import com.example.hackathon_0101.Dto.SearchData;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController {
    SearchData search;
    private List<ResultData> dataList;

    public void setDataList(List<ResultData> dataList) {
        this.dataList = dataList;
    }
    @ResponseBody
    @GetMapping("/search") //frontend에서 검색 데이터 받아옴
    public SearchData Search(SearchData searchData){ //@RequestParam String conference, String year,String keyword
        System.out.println(searchData.getConference());
        System.out.println(searchData.getKeyword());
        System.out.println(searchData.getYear());
        search = searchData;
        return searchData;
    }

    @ResponseBody
    @GetMapping("/search2")
    public SearchData Search(){
        return search;
    }

    @ResponseBody
    @PostMapping("/search2")
    public void SearchResult(@RequestBody HashMap<String, Object> map){ //Map<String, Object>
        System.out.println(map);
    }

    @GetMapping("/result")
    public ResponseEntity<List<ResultData>> getResult(){
        if(this.dataList!= null) return ResponseEntity.ok(this.dataList);
        else return ResponseEntity.notFound().build();
    }




}
