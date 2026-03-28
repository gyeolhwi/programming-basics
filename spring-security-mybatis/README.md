# Spring Security MyBatis

Spring Boot + Spring Security + JWT + MyBatis + OAuth2 인증 서버.

**Tech:** Spring Boot, Spring Security, JWT, MyBatis, H2, OAuth2

## Package Structure

```
com.study.SpringSecurityMybatis/
├── config/       # SecurityConfig
├── security/     # JWT, Filter, Principal
├── controller/   # Auth, OAuth2 controllers
├── service/      # Signup, Signin, OAuth2 services
├── repository/   # MyBatis Mappers
├── entity/       # User, Role, OAuth2User
└── dto/          # Req/Resp DTOs
```

## Features

- 회원가입 / 로그인 (JWT 발급)
- OAuth2 소셜 로그인 (Google, GitHub)
- MyBatis XML mapper 기반 SQL

## Setup

`application-secret.yml`에 값을 채워주세요:

```yaml
jwt:
  secret: your_jwt_secret_key_here

oauth2:
  google:
    client-id: your_google_client_id
    client-secret: your_google_client_secret
```
