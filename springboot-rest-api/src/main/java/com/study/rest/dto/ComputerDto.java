package com.study.rest.dto;

import com.study.rest.entity.Computer;
import lombok.Builder;
import lombok.Data;

public class ComputerDto {

    @Builder
    @Data
    public static class Info {
        private String company;
        private String cpu;
        private int ram;
        private int ssd;

        public Computer toEntity() {
            return Computer.builder()
                    .company(company)
                    .cpu(cpu)
                    .ram(ram)
                    .ssd(ssd)
                    .build();
        }
    }

    @Data
    public static class ListDto{
        private String company;
        private String cpu;

        public Computer toEntity(){
            return Computer.builder()
                    .company(company)
                    .cpu(cpu)
                    .build();
        }
    }

    @Builder
    @Data
    public static class RespGetListDto {
        private int computerId;
        private String company;
    }
    @Builder
    @Data
    public static class RespGetComputerDto{
        private int computerId;
        private String company;
        private String cpu;
        private int ram;
        private int ssd;
    }

    @Data
    public static class ReqUpdateComputerDto {
        private int computerId;
        private String company;
        private String cpu;
        private int ram;
        private int ssd;

        public Computer toEntity(){
            return Computer.builder()
                    .computerId(computerId)
                    .company(company)
                    .cpu(cpu)
                    .ram(ram)
                    .ssd(ssd)
                    .build();
        }
    }

}
