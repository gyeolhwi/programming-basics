package com.study.rest.controller;


import com.study.rest.dto.ComputerDto;
import com.study.rest.service.ComputerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/computer")
public class ComputerController {

    @Autowired
    private ComputerServiceImpl service;

    @PostMapping("/register")
    public ResponseEntity<?> registerApi(@RequestBody ComputerDto.Info reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(service.register(reqDto));
    }

    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ComputerDto.ListDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(service.getComputerList(reqDto));
    }

    //http:.//localhost:8080/api/v1/computer/3
    @GetMapping("/{computerId}")
    public ResponseEntity<?> getApi(@PathVariable int computerId) {
        log.info("{}", computerId);
        return ResponseEntity.ok().body(service.getComputer(computerId));
    }

    @DeleteMapping("/{computerId}")
    public ResponseEntity<?> removeApi(@PathVariable int computerId) {
        log.info("{}", computerId);
        return ResponseEntity.ok().body(service.deleteComputer(computerId));
    }

    @PutMapping("/{computerId}")
    public ResponseEntity<?> modifyApi(@PathVariable int computerId, @RequestBody ComputerDto.ReqUpdateComputerDto dto) {
        log.info("{},{}", computerId, dto);
        return ResponseEntity.ok().body(service.updateComputer(dto));
    }
}
