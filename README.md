# Programming Basics

Java · Spring Boot · React · SQL 기초부터 심화까지 학습 자료 모음

## 학습 로드맵 (Learning Roadmap)

폴더가 많아 어디서부터 시작할지 막막하다면, 아래 순서대로 학습하는 것을 권장합니다.
**언어 → DB → 순수 웹(Servlet) → 프레임워크(Spring) → 프론트(React) → 풀스택 결합 → 배포** 흐름으로,
순수 방식을 먼저 겪고 프레임워크로 넘어가는 정석 순서입니다.

| 단계 | 학습 순서 | 설명 |
|------|-----------|------|
| **1단계 · 언어 기초** | [java-basics](./java-basics/) → [java-advanced](./java-advanced/) | Java 문법부터 OOP·컬렉션·람다·스트림까지, 모든 것의 토대 |
| **2단계 · 데이터베이스** | [sql](./sql/) → [java-dvd-app](./java-dvd-app/) | SQL로 데이터 다루기를 익히고, JDBC로 Java와 DB를 직접 연동 |
| **3단계 · 웹 기초** | [html-css-js](./html-css-js/) → [servlet-dvd-app](./servlet-dvd-app/) → [servlet-auth-app](./servlet-auth-app/) | 프론트 기초 후 Servlet/JSP로 프레임워크 없이 웹의 원리를 체득 |
| **4단계 · Spring Boot** | [springboot-rest-api](./springboot-rest-api/) → [spring-security-mybatis](./spring-security-mybatis/) → [spring-security-jpa](./spring-security-jpa/) | REST API로 시작해 Security·JWT·MyBatis·JPA로 백엔드 확장 |
| **5단계 · React** | [react-tutorial](./react-tutorial/) → [react-crud](./react-crud/) → [react-auth-app](./react-auth-app/) | React 기초 학습 → CRUD 실습 → 인증까지 프론트엔드 심화 |
| **6단계 · 풀스택 통합** | [board-app](./board-app/) → [todolist-app](./todolist-app/) | 백엔드와 프론트를 하나로 묶어 실제 서비스 형태로 완성 |
| **7단계 · 배포** | [spring-boot-deploy](./spring-boot-deploy/) | Docker와 Blue/Green 무중단 배포로 운영 환경까지 경험 |

## Categories

| Folder | Description |
|--------|-------------|
| [java-basics](./java-basics/) | Java 문법 기초 — 변수, 조건, 반복, 메소드, 클래스 |
| [java-advanced](./java-advanced/) | Java 심화 — OOP, 제네릭, 컬렉션, 람다, 스트림, 예외 |
| [java-dvd-app](./java-dvd-app/) | Java + JDBC DVD 관리 앱 |
| [html-css-js](./html-css-js/) | HTML, CSS, JavaScript 기초 + 네이버 클론 |
| [sql](./sql/) | MySQL 쿼리 연습 (CRUD, JOIN, 정규화) |
| [servlet-dvd-app](./servlet-dvd-app/) | Servlet + JSP DVD 관리 웹앱 |
| [servlet-auth-app](./servlet-auth-app/) | Servlet + JSP 로그인/회원가입 웹앱 |
| [springboot-rest-api](./springboot-rest-api/) | Spring Boot + MyBatis REST API |
| [spring-security-jpa](./spring-security-jpa/) | Spring Security + JWT + JPA + AOP |
| [spring-security-mybatis](./spring-security-mybatis/) | Spring Security + JWT + MyBatis + OAuth2 |
| [board-app](./board-app/) | 게시판 풀스택 앱 — Security + MyBatis + OAuth2 + Quill |
| [react-tutorial](./react-tutorial/) | React 챕터별 학습 (ch01~ch18) |
| [react-crud](./react-crud/) | React + Axios CRUD 실습 앱 |
| [react-auth-app](./react-auth-app/) | React + React Query + Firebase 인증 앱 |
| [todolist-app](./todolist-app/) | React + Spring Boot TodoList 풀스택 앱 |
| [spring-boot-deploy](./spring-boot-deploy/) | Blue/Green 무중단 배포 실습 + Docker |

## Tech Stack

- **Java** — Maven, Java 17+
- **Frontend** — HTML5, CSS3, Vanilla JS
- **React** — CRA, React Hooks, Axios, React Query, Recoil
- **Database** — MySQL, JDBC, H2
- **Backend** — Spring Boot, MyBatis, Spring Security, JWT, OAuth2
- **Infra** — Docker, Blue/Green Deployment

## Contributors

| | Name | Role |
|--|------|------|
| 👤 | [gyeolhwi](https://github.com/gyeolhwi) | Developer |
| 🤖 | Claude (Anthropic) | AI Pair Programmer — 코드 정리, 구조화, 민감정보 처리 보조 |
