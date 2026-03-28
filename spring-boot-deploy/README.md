# Spring Boot Deploy

Spring Boot Blue/Green 무중단 배포 실습 프로젝트.

**Tech:** Spring Boot, Docker, Blue/Green Deployment

## Structure

```
spring-boot-deploy/
├── Dockerfile
└── src/
    └── main/
        ├── java/
        │   └── controller/    # TestController, HealthCheckController
        └── resources/
            └── application.yml
```

## Blue/Green 배포 전략

| 프로파일 | 포트 | 역할 |
|---------|------|------|
| `blue` | 8080 | 운영 1번 서버 (현재 서비스 중) |
| `green` | 9090 | 운영 2번 서버 (신버전 배포 후 전환) |
| `local` | 8080 | 개발 환경 |

배포 시 green에 신버전을 올린 뒤 트래픽을 전환하고,
문제 없으면 blue를 green 버전으로 업데이트하는 방식.

## Run

```bash
# 프로파일 지정 실행
./mvnw spring-boot:run -Dspring-boot.run.profiles=blue

# Docker 빌드
docker build -t deploy-app .
docker run -p 8080:8080 deploy-app
```
