package com.ntg.socialnetworkspringcloudin28minuts.controller;

import com.ntg.socialnetworkspringcloudin28minuts.model.FilteringBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filtering")
public class FilteringController {
    @GetMapping
    public ResponseEntity<FilteringBean> getFilteringBean(){
        FilteringBean filteringBean = new FilteringBean("value1", "value2", "value3");
        return new ResponseEntity<>(filteringBean, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FilteringBean>> getFilteringBeanList(){
        List<FilteringBean> filteringBeanList = Arrays.asList(
                new FilteringBean("value1", "value2", "value3"),
                new FilteringBean("value4", "value5", "value6"),
                new FilteringBean("value7", "value8", "value9")
        );
        return new ResponseEntity<>(filteringBeanList, HttpStatus.OK);
    }
}
