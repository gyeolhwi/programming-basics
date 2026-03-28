/** @jsxImportSource @emotion/react */
import { Route, Routes } from 'react-router-dom';
import * as s from './style';

import React from 'react';
import RouteStudyPage from '../../pages/RouteStudyPage/RouteStudyPage';
import HomePage from '../../pages/HomePage/HomePage';
import ParamsStudyPage from '../../pages/ParamsStudyPage/ParamsStudyPage';
import SearchParamsStudy from '../../pages/SearchParamsStudy/SearchParamsStudy';
import CustomHookPage from '../../pages/CustomHookPage/CustomHookPage';
import MemoizationPage from '../../pages/MemoizationPage/MemoizationPage';

function MainBody(props) {
    return (
        <div css={s.layout}>
            <Routes>
                <Route path='/' element={<HomePage />}></Route>
                <Route path='/routestudy/*' element={<RouteStudyPage />} />
                <Route path='/params/:name/*' element={<ParamsStudyPage />}></Route>
                <Route path='/searchparams' element={<SearchParamsStudy />}></Route>
                <Route path='/customhook/:id' element={<CustomHookPage />}></Route>
                <Route path='/memoization/' element={<MemoizationPage />}></Route>
            </Routes>

        </div>
    );
}

export default MainBody;