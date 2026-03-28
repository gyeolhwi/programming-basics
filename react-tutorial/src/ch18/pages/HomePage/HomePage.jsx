/** @jsxImportSource @emotion/react */
import { Link, Route, Routes } from 'react-router-dom';
import * as s from './style';
import React from 'react';

function HomePage() {

    return (
        <div css={s.layout}>
            <h1>메인페이지 입니다.</h1>
            <Link to={"/routestudy"}><h1>이동</h1></Link>
        </div>
    );
}

export default HomePage;