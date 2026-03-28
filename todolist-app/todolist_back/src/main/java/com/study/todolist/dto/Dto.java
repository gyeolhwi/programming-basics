package com.study.todolist.dto;

import com.study.todolist.entity.Todo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dto {

    @Data
    public static class ReqAdd {
        private String title;
        private String content;
        private String dateTime;
        private int important;
        private int busy;

        public Todo toEntity() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            LocalDateTime todoDateTime = LocalDateTime.parse(dateTime + ":00", formatter);

            return Todo.builder()
                    .title(title)
                    .content(content)
                    .todoDateTime(todoDateTime)
                    .important(important)
                    .busy(busy)
                    .build();
        }
    }

    @Data
    @Builder
    public static class Resp{
        private int todoId;
        private String title;
        private String content;
        private String todoDateTime;
        private int important;
        private int busy;
    }

    @Data
    @Builder
    public static class RespCounts{
        private int all;
        private int today;
        private int important;
        private int busy;
        private int complete;
    }
}
