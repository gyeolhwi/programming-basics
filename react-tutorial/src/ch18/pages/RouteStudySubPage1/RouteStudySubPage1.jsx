import React from 'react';
import { Link, Route, Routes, useLocation, useNavigate } from 'react-router-dom';

function RouteStudySubPage1() {
    const navigate = useNavigate();
    const location = useLocation();
    console.log(location.pathname);
    console.log(location.pathname.lastIndexOf("/"));
    const index = location.pathname.lastIndexOf("/");
    console.log(location.pathname.substring(index + 1));

    const handleAgeClick = () => {
        navigate("/routestudy/page1/age", { replace: true });
        // window.location.href = "https://naver.com" => replace: false 
        // window.location.replace("https://naver.com") => replace: true -> 새로고침 , 뒤로가기 안 됨
    }
    return (
        <div>
            <ul>
                <Link to={"/routestudy/page1/name"}><li>이름</li></Link>
                <Link to={"age"} ><li>나이</li></Link>
                <Link to={"address"} ><li>주소</li></Link>
            </ul>
            <button onClick={handleAgeClick}>나이</button>
            <div>
                <Routes>
                    <Route path='/name' element={<div>김결휘</div>}></Route>
                    <Route path='/age' element={<div>26</div>}></Route>
                    <Route path='/address' element={<div>부산시</div>}></Route>
                </Routes>
            </div>
        </div>
    );
}

export default RouteStudySubPage1;