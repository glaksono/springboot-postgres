package com.glcode.simple.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.glcode.simple.model.AppDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CustomerDto extends AppDto {
    @JsonProperty(required = true)
    private String name;

    @JsonProperty(required = true)
    private String lastName;

    @JsonProperty(required = true)
    private String email;

    @JsonProperty(required = true)
    private String address;

}
