package com.ntg.socialnetworkspringcloudin28minuts.util;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

public class JacksonFilteringUtil{
    public static MappingJacksonValue  createMappingJacksonValue(Object mappingBean, String filteringBeanName, String... notIgnoringField){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(mappingBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(notIgnoringField);
        FilterProvider filters = new SimpleFilterProvider().addFilter(filteringBeanName, filter);
        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
