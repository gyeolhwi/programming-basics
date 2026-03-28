# React Auth App

React + React Query + Firebase 기반 인증 프론트엔드.
`spring-security-mybatis` 백엔드와 연동.

**Tech:** React, React Query, Axios, Firebase Storage

## Structure

```
src/
├── apis/         # signApi, tokenApi, oauth2Api, userApi
├── firebase/     # Firebase Storage 설정
├── pages/        # 로그인, 회원가입, 마이페이지 등
├── components/   # 공통 컴포넌트
└── atoms/        # Recoil 전역 상태
```

## Features

- 로그인 / 회원가입 / OAuth2 소셜 로그인
- JWT Access Token + Refresh Token 처리
- Firebase Storage 프로필 이미지 업로드

## Setup

`.env.example`을 복사해 `.env`로 만들고 Firebase 설정값을 채워주세요:

```bash
cp .env.example .env
```

## Run

```bash
npm install
npm start
```
