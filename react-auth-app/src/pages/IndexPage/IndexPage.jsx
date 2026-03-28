import { css } from '@emotion/react';
import React from 'react';
import { useQueryClient } from 'react-query';
/** @jsxImportSource @emotion/react */
import { Link, useNavigate } from 'react-router-dom';

const layout = css`
display: flex;
justify-content: center;
flex-direction: column;
padding: 100px 300px;
`;
const header = css`
display: flex;
justify-content: center;
margin-bottom: 40px;
& > input {
    width: 50%;
    height: 50px;
    height: 40px;
    border-radius: 50px;
    padding: 10px 20px;
}
`
const main = css`
    display: flex;
    justify-content: space-between;
`

const leftBox = css`
    box-sizing: border-box;
    border: 2px solid #dbdbdb;
    border-radius: 10px;
    width: 64%;
`;
const rightBox = css`
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    align-items: center;
    border: 2px solid #dbdbdb;
    border-radius: 10px;
    width: 35%;
    padding: 20px;

    & > button {
        margin-bottom: 10px;
        width: 100%;
        height: 30px;
        font-size: 16px;
        font-weight: 600;
    }

    & > div {
        display: flex;
        justify-content: center;
        width: 100%;

        // 세개의 a태그들 중에서 마지막의 첫번째가 아니면 after 속성
        & > a:not(:nth-last-of-type(1))::after {
            display: inline-block;
            content: "";
            margin: 0px 5px;
            height: 60%;
            border-left: 1px solid #222222;
        }
    }
`;
const userInfoBox = css`
    display: flex;
    justify-content: flex-start;
    width: 100%;
`;
const profileImgBox = css`
    box-sizing: border-box;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    width: 64px;
    height: 64px;
    box-shadow: 0 0 2px #00000088;
    overflow: hidden;
    & > img {
        height: 100%;
    }
`;
const profileInfo = css`
    box-sizing: border-box;
    display: flex;
    justify-content: space-between;
    flex-grow: 1;
    padding: 10px;

    & > button{
        box-sizing: border-box;
        border: 1px solid #dbdbdbdb;
        border-radius: 37px;
        height: 37px;
        background-color: #ffffff;
        color: #555555;
        cursor: pointer;
    }
`;

function IndexPage(props) {
    const queryClient = useQueryClient();
    const accessTokenValidState = queryClient.getQueryState("accessTokenValidQuery");
    const userInfostate = queryClient.getQueryState("userInfoQuery");

    console.log(userInfostate);
    console.log(accessTokenValidState);

    const navigate = useNavigate();

    const handleLoginButtonOnClick = () => {
        navigate("/user/login");
    }

    // 로그아웃
    const handleLogoutButtonOnclick = () => {
        if (window.confirm("로그아웃 하시겠습니까?")) {
            localStorage.removeItem("accessToken");
            window.location.replace("/");
        }
    }

    return (
        /*
        <div css={layout}>
            <header css={header}>
                <input type="search" placeholder='검색어를 입력해 주세요' />
            </header>
            {
                userInfostate.status === "success" || accessTokenValidState.status === "success"
                    ? <></>
                    :
                    <main css={main}>
                        <div css={leftBox}></div>
                        {
                            userInfostate.status === "success" &&
                            <div css={rightBox}>
                                <div css={userInfoBox}>
                                    <div css={profileImgBox}>
                                        <img src="" alt="" />
                                    </div>
                                    <div css={profileInfo}>
                                        <div>
                                            <div>{userInfostate.data.data.username}님</div>
                                            <div>{userInfostate.data.data.email}</div>
                                        </div>
                                        <button onClick={handleLogoutButtonOnclick}>로그아웃</button>
                                    </div>
                                </div>
                            </div>
                        }
                        {
                            userInfostate.status !== "success" &&
                            // ------------------------------------------------------------
                            <div css={rightBox}>                                        
                                <p>더 안전하고 편리하게 이용하세요</p>
                                <button onClick={handleLoginButtonClick}>로그인</button>
                                <div>
                                    <Link to={"/user/help/id"} >아이디 찾기</Link>
                                    <Link to={"/user/help/pw"} >비밀번호 찾기</Link>
                                    <Link to={"/user/join"} >회원가입</Link>
                                </div>
                            </div>
                            // -------------------------------------------------------------
                        }
                    </main>
            }
        </div >
        */
        <div css={layout}>
            <header css={header}>
                <input type="search" placeholder='검색어를 입력해 주세요.' />
            </header>
            <main css={main}>
                <div css={leftBox}></div>
                {
                    accessTokenValidState.status !== "success"
                        ?
                        accessTokenValidState.status !== "error"
                            ?
                            <></>
                            :
                            <div css={rightBox}>
                                <p>더 안전하고 편리하게 이용하세요</p>
                                <button onClick={handleLoginButtonOnClick}>로그인</button>
                                <div>
                                    <Link to={"/user/help/id"}>아이디 찾기</Link>
                                    <Link to={"/user/help/pw"}>비밀번호 찾기</Link>
                                    <Link to={"/user/join"}>회원가입</Link>
                                </div>
                            </div>
                        :
                        <div css={rightBox}>
                            <div css={userInfoBox}>
                                <div css={profileImgBox} onClick={() => navigate("/profile")}>
                                    <img src={userInfostate.data?.data.img} alt="" />
                                </div>
                                <div css={profileInfo}>
                                    <div>
                                        <div>{userInfostate.data?.data.username}님</div>
                                        <div>{userInfostate.data?.data.email}</div>
                                    </div>
                                    <button onClick={handleLogoutButtonOnclick}>로그아웃</button>
                                </div>
                            </div>
                        </div>
                }
            </main>
        </div>
    );
}

export default IndexPage;