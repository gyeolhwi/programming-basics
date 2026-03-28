# Board App

Spring Security + MyBatis + OAuth2 + Quill 에디터 기반 게시판 풀스택 앱.

## Structure

```
board-app/
├── board_back/    # Spring Boot 백엔드
└── board_front/   # React 프론트엔드
```

## board_back

**Tech:** Spring Boot, Spring Security, MyBatis, JWT, OAuth2, H2

```
com.study.SpringSecurityMybatis/
├── controller/    # Auth, Board, Comment, User
├── service/       # 비즈니스 로직
├── repository/    # MyBatis Mappers
├── entity/        # User, Role, Board, Comment
├── security/      # JWT 필터, Principal
└── dto/           # Req/Resp DTOs
```

**Mappers:** user, role, board, comment, board_like, oauth2_user

## board_front

**Tech:** React, React Query, Axios, Quill

```
src/
├── apis/          # signApi, boardApi, tokenApi, oauth2Api
├── pages/         # 게시판 목록, 상세, 작성 페이지
└── components/    # 공통 컴포넌트
```

## Setup

`board_back/src/main/resources/application-secret.yml`에 OAuth2 키와 JWT secret을 채워주세요.

```bash
# 프론트엔드
cd board_front && npm install && npm start

# 백엔드
cd board_back && ./mvnw spring-boot:run
```
