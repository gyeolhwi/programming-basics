package com.study.todolist.service;

import com.study.todolist.dto.Dto;
import com.study.todolist.entity.Todo;
import com.study.todolist.repository.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    @Autowired
    private TodoMapper todoMapper;

    public int addTodo(Dto.ReqAdd dto){
        return todoMapper.save(dto.toEntity());
    }

    public List<Dto.Resp> getTodoList(){
        return todoMapper.findAll().stream().map(Todo::toDto).collect(Collectors.toList());
    }
    public Dto.RespCounts getTodoCounts(){
        return todoMapper.getTodoCounts().toDto();
    }

}
