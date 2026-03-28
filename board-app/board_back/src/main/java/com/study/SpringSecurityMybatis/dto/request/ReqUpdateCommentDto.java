package com.study.SpringSecurityMybatis.dto.request;

import com.study.SpringSecurityMybatis.entity.Comment;
import lombok.Data;

@Data
public class ReqUpdateCommentDto {
    private Long id;
    private String content;

    public Comment toEntity(){
        return Comment.builder()
                .id(id)
                .content(content)
                .build();
    }
}
