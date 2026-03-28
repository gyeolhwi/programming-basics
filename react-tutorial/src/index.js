import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './ch18/App';
import { BrowserRouter } from 'react-router-dom';
import { RecoilRoot } from 'recoil';

const root = ReactDOM.createRoot(document.getElementById('root'));
// html -> root id를 가지고있는 녀석에게 랜더링 하겠다 (최상단 돔으로 지정)

root.render(
    <RecoilRoot>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </RecoilRoot>
);

// 함수를 리턴하는 것이라 굳이 App이 아니어도 됨