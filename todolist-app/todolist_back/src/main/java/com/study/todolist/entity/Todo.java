package com.study.todolist.entity;


import com.study.todolist.dto.Dto;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@Data
@NoArgsConstructor // MyBatis 라이브러리 -> setter로 매칭 시켜줌
@AllArgsConstructor  // Builder 사용 때 써짐 근데 이러면 NoArgs가 사용되지 못하기 때문
public class Todo {

    private int todoId;
    private int userId;
    private String title;
    private String content;
    private int important;
    private int busy;
    private int status;
    private LocalDateTime todoDateTime;

    public Dto.Resp toDto() {
        return Dto.Resp.builder()
                .todoId(todoId)
                .title(title)
                .content(content)
                .todoDateTime(todoDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm"))) // LocalDateTime형식 바꿔줌
                .important(important)
                .busy(busy)
        .build();
    }
//    private LocalDateTime createDate;
//    private LocalDateTime updateDate;

}
