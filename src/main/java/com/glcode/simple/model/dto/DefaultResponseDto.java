package com.glcode.simple.model.dto;

import com.glcode.simple.model.AppDto;
import lombok.Getter;

@Getter
public class DefaultResponseDto {

    private String value;
    private AppDto data;

    private void setValue(String value){
        this.value = value;
    }
    private void setData(AppDto data){
        this.data = data;
    }

    private DefaultResponseDto(){}

    public static DefaultResponseDto create(String val){
        DefaultResponseDto dto = new DefaultResponseDto();
        dto.setValue(val);
        return dto;
    }

    public static DefaultResponseDto create(String val, AppDto o){
        DefaultResponseDto dto = new DefaultResponseDto();
        dto.setValue(val);
        dto.setData(o);
        return dto;
    }

    public static DefaultResponseDto create(AppDto o){
        DefaultResponseDto dto = new DefaultResponseDto();
        dto.setData(o);
        return dto;
    }
}
