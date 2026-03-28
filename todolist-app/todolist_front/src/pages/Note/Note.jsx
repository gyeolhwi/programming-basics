import React, { useEffect, useState } from 'react';
/** @jsxImportSource @emotion/react */
import * as s from "./style";

function Note(props) {
    const user = {
        username: "aaa",
        password: "1234",
        "user-name": "test22"
    }

    const { username = "test", password, name = "김준일" } = user;
    const { username: username2 } = user;
    const { ["user-name"]: username3 = "default" } = user;
    user["name"] = "김준일";

    // 비구조할당에서 

    // const { "username2": username, ...rest } = user;
    let b = "bbbb"
    const aa = {
        a: "a",
        b
    }

    const user2 = {
        username,
        password,
        name
    }

    // console.log(aa);
    // console.log(user2);

    console.log(username);
    console.log(username2);
    console.log(username3);

    // key값이 일치할 떄 사용 할 필요가 없는데, 그게 지금 안 그려져



    const a = {
        backgroundColor: "black"
    }
    const [inputText, setInputText] = useState({
        메모: ""
    });
    const handleOnChange = (e) => {
        if (e.key === 'Tab') {
            e.preventDefault();
            return;
        }
        setInputText(text => {
            return {
                ...text,
                [e.target.name]: e.target.value
            }
        }
        );
    }

    const handleKeyUp = (e) => {

        if (e.shiftKey && e.key === 'Enter') {
            return;
        }

        if (e.key === 'Enter') {
            handleSubmitClick();
        }
    }
    const EmptyInput = () => {
        setInputText({
            메모: ""
        });
    }


    const handleSubmitClick = () => {
        if (!inputText.메모.trim()) {
            alert("메모를 입력하세요");
            EmptyInput();
            return;
        }

        let text = inputText.메모;
        console.log("메모:\n" + text/*.replace("\n", "\n")*/);
        EmptyInput();
    }




    return (
        <div css={s.layout}>
            <h2>메모</h2>
            <textarea name="메모" id="" onChange={handleOnChange} onKeyUp={handleKeyUp} value={inputText.메모} autoFocus></textarea>
            <button onClick={handleSubmitClick} >확인</button>

        </div>





    );
}

export default Note;