package com.study.todolist.controller;


import com.study.todolist.dto.Dto;
import com.study.todolist.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todolist")
    public ResponseEntity<?> getAll() {
        System.out.println("호출");
        return ResponseEntity.ok().body(todoService.getTodoList());
    }

    @PostMapping("/todo")
    public ResponseEntity<?> add(@RequestBody Dto.ReqAdd dto) {
        int successCount = todoService.addTodo(dto);
        log.info("{}", dto);
        return ResponseEntity.created(null).body(successCount);
    }
    @GetMapping("/todo/counts")
    public ResponseEntity<?> getCounts(){
        return ResponseEntity.ok().body(todoService.getTodoCounts());
    }
}
