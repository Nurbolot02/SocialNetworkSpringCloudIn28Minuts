package com.ntg.socialnetworkspringcloudin28minuts.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonFilter("FilteringBean1")
public class FilteringBean {
    private String value1;
    private String value2;
    private String value3;
}
