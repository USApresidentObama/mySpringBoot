package com.aixuexi.model;

import lombok.Data;

import java.util.List;

/**
 * @Author zengfeiyang
 * @Date: 2022-04-01 18:22
 * @Description
 */
@Data
public class PositionInfoDto {
    private Integer id;

    private List<PositionInfoDto> subPositionInfoDtoList;

    public PositionInfoDto(Integer id) {
        this.id = id;
    }
}
