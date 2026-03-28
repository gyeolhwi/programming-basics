import React, { useState } from 'react';
/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import { Link, useNavigate } from 'react-router-dom';
import { signinApi, signupAPi } from '../../apis/signApi';
import { instance } from '../../apis/util/instance';

const layout = css`
    display: flex;
    flex-direction: column;
    margin: 0px auto;
    width: 460px;
`;
const logo = css`
    font-size: 24px;
    margin-bottom: 40px;
`;
const joinInfoBox = css`
    display: flex;
    flex-direction: column;
    margin-bottom: 20px;
    width: 100%;
    & input {
        box-sizing: border-box;
        border: none;
        outline: none;
        width: 100%;
        height: 50px;
        font-size: 16px;
    }
    & p {
        margin: 0 0 10px 10px;
        color: #ff2f2f;
        font-size: 12px;
    }

    & div {
        box-sizing: border-box;
        width: 100%;
        border: 1px solid #dbdbdb;
        border-bottom: none;
        padding: 0px 20px;
    }
    & div:nth-of-type(1){
        border-radius: 10px 10px 0 0;
    }
    & div:nth-last-of-type(1){
        border-bottom: 1px solid #dbdbdb;
        /* border-bottom-right-radius: 10px; */
        /* border-bottom-left-radius: 10px; */
        border-radius: 0 0 10px 10px;
    }
`;

const joinButton = css`
    border: none;
    border-radius: 10px;
    width: 100%;
    height: 50px;
    background-color: #dbdbdb;
    color: #ffffff;
    font-size: 18px;
    font-weight: 600;
    cursor: pointer;
`;

function UserLoginPage(props) {
    const navigate = useNavigate();

    const [inputUser, setInputUser] = useState({
        username: "",
        password: "",
    });

    const [fieldErrorMessages, setFieldErrorMessages] = useState({
        username: <></>,
        password: <></>,
    })

    const handleInputUserOnChange = (e) => {
        setInputUser(user => ({
            ...user,
            [e.target.name]: e.target.value
        }))
    }


    const showFieldErrorMessage = (fieldErrors) => {
        let EmptyFieldErrors = {
            username: <></>,
            password: <></>,
        }

        for (let fieldError of fieldErrors) {
            EmptyFieldErrors = {
                ...EmptyFieldErrors,
                [fieldError.field]: <p>{fieldError.defaultMessage}</p>
            }
            setFieldErrorMessages(EmptyFieldErrors);
            return;
        }
    }

    const handleLoginSubmitOnClick = async () => {
        const response = await signinApi(inputUser);
        console.log(response);
        if (!response.isSuccess) {
            if (response.errorStatus === 'fieldError') {
                showFieldErrorMessage(response.error);
            }
            if (response.errorStatus === 'loginError') {
                let EmptyFieldErrors = {
                    username: <></>,
                    password: <></>,
                }
                setFieldErrorMessages(EmptyFieldErrors);
                alert(response.error)
            }
            return;
        }
        // alert(`${response.token.accessToken}`);
        // navigate("/");

        // instance에 accessToken값을 넣어주는 과정 → 서버시작할 때 고정적으로 가지고있을것이기 때문에
        localStorage.setItem("accessToken", "Bearer " + response.token.accessToken);

        // console.log(window.history.length);
        instance.interceptors.request.use(config => {
            config.headers["Authorization"] = localStorage.getItem("accessToken");
            return config;
        });

        if (window.history.length > 2) {
            // window.history.back(-1);
            navigate(-1);
            return;
        }

        navigate("/");
        // window.location.replace("/"); 인터셉트로 재랜더링이 필요없기 때문
    }

    return (
        <div css={layout}>
            <Link to={'/'}><h1 css={logo}>사이트 로고</h1> </Link>
            <div css={joinInfoBox}>
                <div><input name='username' type="text" placeholder='아이디' onChange={handleInputUserOnChange} value={inputUser.username} />
                    {fieldErrorMessages.username}
                </div>
                <div><input name='password' type="password" placeholder='비밀번호' onChange={handleInputUserOnChange} value={inputUser.password} />
                    {fieldErrorMessages.password}
                </div>
            </div>
            <button css={joinButton} onClick={handleLoginSubmitOnClick}>로그인</button>
            <a href="http://localhost:8080/oauth2/authorization/google">구글로그인</a>
            <a href="http://localhost:8080/oauth2/authorization/naver">네이버로그인</a>
            <a href="http://localhost:8080/oauth2/authorization/kakao">카카오로그인</a>
        </div>
    );
}

export default UserLoginPage; 