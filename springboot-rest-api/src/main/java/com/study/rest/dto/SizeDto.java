package com.study.rest.dto;

import com.study.rest.entity.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

public class SizeDto {

    // 단건조회
    @Builder
    @Data
    public static class Info{
        // 불러와지는 데이터들 선언
        private int sizeId;
        private String sizeName;

        public Size toEntity(){
            return Size.builder()
                    .sizeName(sizeName)
                    .build();
        }


    }
    /*

    // 다건조회
    @Builder
    @Data
    public static class ListResponse {
        List<Info> sizeList;
    }
    */

    public static List<Info> toList(List<Size> sizeList) {
        return  sizeList.stream().map(Size::toDto).collect(Collectors.toList());
    }
}
