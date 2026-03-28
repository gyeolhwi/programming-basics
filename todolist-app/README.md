# Todolist App

React + Spring Boot + MyBatis 풀스택 TodoList 토이프로젝트.

## Structure

```
todolist-app/
├── todolist_front/   # React 프론트엔드
└── todolist_back/    # Spring Boot 백엔드
```

## todolist_front

**Tech:** React, Recoil, Axios, Emotion

```
src/
├── apis/       # todoApis (add, get)
├── atoms/      # todolistAtoms, modalAtoms
├── components/ # Todo 컴포넌트
├── pages/      # 페이지
└── constants/  # menus
```

## todolist_back

**Tech:** Spring Boot, MyBatis, MySQL

```
com.toyproject.todolist/
├── controller/   # TodoController
├── service/      # TodoService
├── repository/   # TodoMapper
├── entity/       # Todo
└── dto/          # ReqTodoListDto, RespTodoListDto, ReqUpdateTodoDto
```

## Setup

`todolist_back/src/main/resources/application-secret.yml`에 DB 정보를 채워주세요.

## Run

```bash
# 백엔드
cd todolist_back && ./mvnw spring-boot:run

# 프론트엔드
cd todolist_front && npm install && npm start
```
