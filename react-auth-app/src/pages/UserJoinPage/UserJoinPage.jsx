import React, { useState } from 'react';
/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import { Link, useNavigate } from 'react-router-dom';
import { signupAPi } from '../../apis/signApi';

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

function UserJoinPage(props) {
    const navigate = useNavigate();

    const [inputUser, setInputUser] = useState({
        username: "",
        password: "",
        checkPassword: "",
        name: "",
        email: ""
    });

    const [fieldErrorMessages, setFieldErrorMessages] = useState({
        username: <></>,
        password: <></>,
        checkPassword: <></>,
        name: <></>,
        email: <></>
    })

    const handleInputUserOnChange = (e) => {
        setInputUser(user => ({
            ...user,
            [e.target.name]: e.target.value
        }))
    }
    const handleJoinSubmitOnClick = async () => {
        const response = await signupAPi(inputUser);
        console.log(response);
        if (!response.isSuccess) {
            showFieldErrorMessage(response.fieldErrors);
            return;
        }


        alert(`${response.ok.message}`)
        navigate("/user/login");

    }

    const showFieldErrorMessage = (fieldErrors) => {
        let EmptyFieldErrors = {
            username: <></>,
            password: <></>,
            checkPassword: <></>,
            name: <></>,
            email: <></>
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
                <div><input name='checkPassword' type="password" placeholder='비밀번호 확인' onChange={handleInputUserOnChange} value={inputUser.checkPassword} />
                    {fieldErrorMessages.checkPassword}
                </div>
                <div><input name='name' type="text" placeholder='성명' onChange={handleInputUserOnChange} value={inputUser.name} />
                    {fieldErrorMessages.name}
                </div>
                <div><input name='email' type="email" placeholder='이메일주소' onChange={handleInputUserOnChange} value={inputUser.email} />
                    {fieldErrorMessages.email}
                </div>
            </div>
            <button css={joinButton} onClick={handleJoinSubmitOnClick}>가입하기</button>
        </div>
    );
}

export default UserJoinPage; 