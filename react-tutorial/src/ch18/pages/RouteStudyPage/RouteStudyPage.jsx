/** @jsxImportSource @emotion/react */
import { Link, Route, Routes } from 'react-router-dom';
import MainContainer from '../../components/MainContainer/MainContainer';
import * as s from './style';

import React from 'react';
import RouteStudySubPage1 from '../RouteStudySubPage1/RouteStudySubPage1';
import RouteStudySubPage2 from '../RouteStudySubPage2/RouteStudySubPage2';
import RouteStudySubPage3 from '../RouteStudySubPage3/RouteStudySubPage3';
import HomePage from '../HomePage/HomePage';

function RouteStudyPage(props) {
    return (
        <MainContainer>
            <div>
                <h1>라우트 수업</h1>
                <ul>
                    <Link to={"/"}><li>홈페이지</li></Link>
                    <Link to={"/routestudy/page1"}><li>1번페이지</li></Link>
                    <Link to={"page2"}><li>2번페이지</li></Link>
                    <Link to={"page3"}><li>3번페이지</li></Link>
                </ul>
                <div>
                    <Routes>
                        {/* <Route path='/' element={<HomePage />}></Route> */}
                        <Route path='/page1/*' element={<RouteStudySubPage1 />}></Route>
                        <Route path='page2/*' element={<RouteStudySubPage2 />}></Route>
                        <Route path='/page3/*' element={<RouteStudySubPage3 />}></Route>
                    </Routes>
                </div>
            </div>
        </MainContainer>
    );
}

export default RouteStudyPage;