package com.ntg.socialnetworkspringcloudin28minuts.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Positive
    private Long id;
    @Size(min = 3)
    private String name;
    @Past
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
