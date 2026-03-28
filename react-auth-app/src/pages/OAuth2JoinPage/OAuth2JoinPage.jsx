/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import React, { useState } from 'react';
import { Link, useNavigate, useSearchParams } from 'react-router-dom';
import { oauth2MergeApi, oauth2SignupApi } from '../../apis/oauth2Api';

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

const selectMenuBox = css`
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 100%;

    & > input {
        display: none;
    }
    & > label{
        box-sizing: border-box;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-grow: 1;
        border: 1px solid #dbdbdbdb;
        height: 40px;
        cursor: pointer;
    }
    & > label:nth-of-type(1){
        border-radius: 10px 0 0 10px;
    }

    & > label:nth-last-of-type(1){
        border-radius: 0 10px 10px 0;
    }

    & > input:checked + label{
        background-color: #fafafafa;
        box-shadow: 0 0 5px #00000033 inset;
    }
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

function OAuth2JoinPage(props) {
    const navigate = useNavigate();
    const [searchParams] = useSearchParams();

    const [selectMenu, setSelectMenu] = useState("merge");

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
        }
        setFieldErrorMessages(EmptyFieldErrors);
        return;
    }

    const handleSelectMenuOnChange = (e) => {
        setFieldErrorMessages({
            username: <></>,
            password: <></>,
            checkPassword: <></>,
            name: <></>,
            email: <></>
        });
        setInputUser({
            username: "",
            password: "",
            checkPassword: "",
            name: "",
            email: ""
        })
        setSelectMenu(e.target.value);
    }

    const handleInputUserOnChange = (e) => {
        setInputUser(user => ({
            ...user,
            [e.target.name]: e.target.value
        }))
    }

    const handleMergeSubmitOnclick = async () => {
        const mergeUser = {
            username: inputUser.username,
            password: inputUser.password,
            oauth2Name: searchParams.get("oAuth2Name"),
            provider: searchParams.get("provider"),
        }
        console.log(mergeUser);
        const mergeData = await oauth2MergeApi(mergeUser);
        if (!mergeData.isSuccess) {
            if (mergeData.errorStatus === "loginError") {
                alert(mergeData.error);
                return;
            }
            if (mergeData.errorStatus === "fieldErrors") {
                showFieldErrorMessage(mergeData.error);
                return;
            }
        }
        alert("계정통합완료");
        navigate("/");
    }





    // 내가 만들어볼꺼
    const handleJoinSubmitOnClick = async () => {
        const mergeUser = {
            username: inputUser.username,
            password: inputUser.password,
            checkPassword: inputUser.checkPassword,
            name: inputUser.name,
            email: inputUser.email,
            oauth2Name: searchParams.get("oAuth2Name"),
            provider: searchParams.get("provider"),
        }
        const oAuth2Data = await oauth2SignupApi(mergeUser);

    }

    //강사님꺼
    const lecturhandleJoinSubmitOnClick = async () => {
        const joinUser = {
            ...inputUser,
            oauth2Name: searchParams.get("oAuth2Name"),
            provider: searchParams.get("provider"),
        }

        const joinData = await oauth2SignupApi(joinUser);
        if (!joinData.isSuccess) {
            showFieldErrorMessage(joinData.fieldErrors);
            return;
        }
        alert("회원가입이 완료되었습니다.");
        navigate("/user/login");

    }



    return (
        <div css={layout}>
            <Link to={'/'}><h1 css={logo}>사이트 로고</h1> </Link>
            <div css={selectMenuBox}>
                <input type="radio" id='merge' name="selectMenu"
                    onChange={handleSelectMenuOnChange}
                    checked={selectMenu === "merge"} value="merge" />
                <label htmlFor="merge">계정통합</label>

                <input type="radio" id='join' name="selectMenu"
                    onChange={handleSelectMenuOnChange}
                    checked={selectMenu === "join"} value="join" />
                <label htmlFor="join">회원가입</label>
            </div>
            {
                selectMenu === "merge"
                    ?
                    <>
                        <div css={joinInfoBox}>
                            <div><input name='username' type="text" placeholder='아이디' onChange={handleInputUserOnChange} value={inputUser.username} />
                                {fieldErrorMessages.username}
                            </div>
                            <div><input name='password' type="password" placeholder='비밀번호' onChange={handleInputUserOnChange} value={inputUser.password} />
                                {fieldErrorMessages.password}
                            </div>
                        </div>
                        <button css={joinButton} onClick={handleMergeSubmitOnclick}>통합하기</button>
                    </>
                    :
                    <>
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
                        <button css={joinButton} onClick={lecturhandleJoinSubmitOnClick}>가입하기</button>
                    </>
            }
        </div>
    );
}

export default OAuth2JoinPage;