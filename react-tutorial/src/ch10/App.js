import { useRef, useState } from "react";
import "./App.css"
function App() {
    const emptyUser = {
        username: "",
        password: "",
        name: ""
    };


    const refs = {
        usernameRef: useRef(),
        passwordRef: useRef(),
        nameRef: useRef()
    };

    const { usernameRef, passwordRef, nameRef } = refs;

    const [userInput, setUserInput] = useState({ ...emptyUser });

    const [userList, setUserList] = useState([]);


    const handleInput = (e) => {
        setUserInput(user => {
            return {
                ...user,
                [e.target.name]: e.target.value
            }
        })
    }


    const handleKeyDown = (e) => {
        if (e.keyCode === 13) {
            // if (e.target.name === "username") {
            //     passwordRef.current.focus();
            // }
            if (e.target.name === "password") {
                nameRef.current.focus();
            }
            if (e.target.name === "name") {
                usernameRef.current.focus();
                setUserList(user => [...user, userInput]);
                setUserInput({ ...emptyUser });
            }
        }
    }

    return <>
        <input name="username" type="text" placeholder="사용자명" value={userInput.username} onChange={handleInput} onKeyDown={(e) => { e.keyCode === 13 ? passwordRef.current.focus() : usernameRef.current.focus() }} ref={usernameRef} />
        <input name="password" type="text" placeholder="비밀번호" value={userInput.password} onChange={handleInput} onKeyDown={handleKeyDown} ref={passwordRef} />
        <input name="name" type="text" placeholder="이름" value={userInput.name} onChange={handleInput} onKeyDown={handleKeyDown} ref={nameRef} />

        <table>
            <thead>
                <tr>
                    <th>순서</th>
                    <th>사용자명</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                </tr>
            </thead>
            <tbody>
                {userList.map((user, index) => <tr key={index}>
                    <td>{index + 1}</td>
                    <td>{user.username}</td>
                    <td>{user.password}</td>
                    <td>{user.name}</td>
                </tr>)}</tbody>
        </table>
    </>
}
export default App;