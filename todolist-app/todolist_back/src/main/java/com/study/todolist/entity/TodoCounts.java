package com.study.todolist.entity;

import com.study.todolist.dto.Dto;
import lombok.Data;

@Data
public class TodoCounts {
    private int all;
    private int today;
    private int important;
    private int busy;
    private int complete;

    public Dto.RespCounts toDto(){
        return Dto.RespCounts.builder()
                .all(all)
                .today(today)
                .important(important)
                .busy(busy)
                .complete(complete)
                .build();
    }
}
