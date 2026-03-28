# Spring Security JPA

Spring Boot + Spring Security + JWT + JPA 인증 서버.
AOP(관점 지향 프로그래밍) 실습 포함.

**Tech:** Spring Boot, Spring Security, JWT, JPA, H2, AOP

## Package Structure

```
com.sutdy.SpringSecurity/
├── config/       # SecurityConfig
├── security/     # JwtProvider, JwtAccessTokenFilter, PrincipalUser
├── controller/   # AuthenticationController, RoleController
├── service/      # SignupService, SigninService
├── domain/       # User, Role, UserRole entities
├── aspect/       # TimeAspect, ValidAspect, ParamsPrintAspect (AOP)
├── dto/          # ReqSigninDto, ReqSignupDto, RespJwtDto
└── init/         # RoleDataLoader
```

## Features

- 회원가입 / 로그인 (JWT 발급)
- Spring Security 필터 체인 구성
- AOP: 실행시간 측정, 유효성 검사, 파라미터 로깅

## Setup

`application.yml`의 JWT secret을 본인 키로 교체하세요:

```yaml
jwt:
  secret: your_jwt_secret_key_here
```
