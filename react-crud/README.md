# React CRUD

React + Axios를 활용한 비동기 CRUD 실습 앱.

## Run

```bash
npm install
npm start
```

## Structure

```
src/
├── components/   # Sidebar, MainContainer, MainLayout
├── pages/        # GetPage, PostPage, PutPage, DeletePage, PromisePage
├── hooks/        # useInput (custom hook)
├── constants/    # productOptions, basicMenu
└── styles/       # global styles
```

## Features

- GET / POST / PUT / DELETE 요청 실습
- Axios 기반 HTTP 통신
- `useInput` 커스텀 훅
