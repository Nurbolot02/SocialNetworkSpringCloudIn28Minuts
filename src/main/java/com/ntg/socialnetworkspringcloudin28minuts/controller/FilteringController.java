package com.ntg.socialnetworkspringcloudin28minuts.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ntg.socialnetworkspringcloudin28minuts.model.FilteringBean;
import com.ntg.socialnetworkspringcloudin28minuts.util.JacksonFilteringUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filtering")
public class FilteringController {
    @GetMapping
    public ResponseEntity<MappingJacksonValue> getFilteringBean(){
        FilteringBean filteringBean = new FilteringBean("value1", "value2", "value3");
        String filteringBeanName = "FilteringBean1";
        MappingJacksonValue mappingJacksonValue = JacksonFilteringUtil.createMappingJacksonValue(filteringBean, filteringBeanName, "value1", "value2");
        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<MappingJacksonValue> getFilteringBeanList(){
        List<FilteringBean> filteringBeanList = Arrays.asList(
                new FilteringBean("value1", "value2", "value3"),
                new FilteringBean("value4", "value5", "value6"),
                new FilteringBean("value7", "value8", "value9")
        );
        String filteringBeanName = "FilteringBean1";
        MappingJacksonValue mappingJacksonValue = JacksonFilteringUtil.createMappingJacksonValue(filteringBeanList, filteringBeanName, "value2", "value3");

        return new ResponseEntity<>(mappingJacksonValue, HttpStatus.OK);
    }
}
