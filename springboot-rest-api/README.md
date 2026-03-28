# Spring Boot REST API

Spring Boot + MyBatis 기반 REST API 실습.

**Tech:** Spring Boot, MyBatis, MySQL, Maven

## Structure

```
com.study.rest/
├── dto/          # Product, Computer, Color, Size, Teacher, Student DTOs
├── repository/   # MyBatis Mappers
└── resources/
    ├── mappers/  # XML mapper files
    └── templates/
```

## Features

- Product / Computer / Color / Size CRUD
- MyBatis XML mapper 기반 SQL
- 공통 응답 포맷 (`CommonResponseDto`)

## Setup

`src/main/resources/application.yml`에서 DB 설정을 수정하세요.
