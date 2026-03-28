package com.study.rest.service;

import com.study.rest.dto.ComputerDto;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl {
    @Autowired
    private ComputerMapper mapper;

    public int register(ComputerDto.Info dto){
        int result = 0;

        Computer computer = Computer.builder()
                .company(dto.getCompany())
                .cpu(dto.getCpu())
                .ram(dto.getRam())
                .ssd(dto.getSsd())
                .build();

        result = mapper.save(computer);


//        return CommonResponseDto.ofDefault(mapper.save(dto.toEntity()));
        return result;
    }

    public List<ComputerDto.RespGetListDto> getComputerList(ComputerDto.ListDto reqDto){
        List<Computer> computers = mapper.findComputerByCompanyAndCpu(reqDto.toEntity());
        /*
        List<ComputerDto.RespGetListDto> respDtos = new ArrayList<>();


        for (Computer com : computers) {
            ComputerDto.RespGetListDto dto = ComputerDto.RespGetListDto.builder()
                    .computerId(com.getComputerId())
                    .company(com.getCompany())
                    .build();

            respDtos.add(dto);
        }
            */
//        return respDtos;
        return computers.stream().map(com ->ComputerDto.RespGetListDto.builder()
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
        ).collect(Collectors.toList());
    }

    public ComputerDto.RespGetComputerDto getComputer(int computerId){
        Computer computer = mapper.findComputerByComputerById(computerId);

        return ComputerDto.RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }
    public boolean deleteComputer(int computerId) {
        return mapper.delete(computerId) > 0;
    }
    public boolean updateComputer(ComputerDto.ReqUpdateComputerDto dto){
        return mapper.update(dto.toEntity()) > 0;
    }


}
