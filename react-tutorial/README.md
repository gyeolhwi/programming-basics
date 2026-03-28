# React Tutorial

React 챕터별 학습 — CRA 프로젝트, ch01~ch18.

## Run

```bash
npm install
npm start
```

## Topics

| Chapter | Topic |
|---------|-------|
| ch01 | Components, props, custom input |
| ch02~ch05 | JSX, state, events |
| ch06~ch09 | Hooks (useState, useEffect) |
| ch10~ch11 | Lists, keys, conditional rendering |
| ch12~ch13 | Context, Promise basics |
| ch14~ch15 | React Router |
| ch16~ch18 | Advanced patterns |

## Key Hooks

| Hook | Description |
|------|-------------|
| `useState` | 값이 변경될 때마다 리렌더링 |
| `useEffect` | 초기 1회 실행, 종속성에 따라 리렌더링 |
| `useRef` | DOM 요소 직접 접근 (querySelector 대체) |
| `useMemo` | 변수의 불필요한 리렌더링 방지 |
| `useCallback` | 함수의 불필요한 리렌더링 방지 |
| `useNavigate` | 페이지 이동 |
| `useParams` | URL 파라미터 접근 |

## Libraries

```bash
npm i react-router-dom     # Router
npm i @emotion/react       # CSS-in-JS
npm i recoil               # 전역 상태 관리
npm i react-icons          # 아이콘
npm i sweetalert2          # 알림창
```

## Conventions

- 컴포넌트 이름은 대문자로 시작
- 컴포넌트 폴더 = `ComponentName.jsx` + `style.js`
- 상수는 `UPPER_SNAKE_CASE`
- 이벤트 핸들러는 `handle` + 이벤트명 (예: `handleClick`)
