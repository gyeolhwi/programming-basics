import { useState } from "react";

function App() {
    // input에 각각 입력 후 확인을 누르면 조회
    const emptyUser = {
        name: "",
        password: "",
        email: ""
    }
    const [user, setUser] = useState({ ...emptyUser })

    // const handleClick = () => {
    //     const inputList = document.querySelectorAll("input");
    //     for (let i = 0; i < 3; i++) {
    //         setUser(user => {
    //             return {
    //                 ...user,
    //                 [inputList[i].name]: inputList[i].value
    //             }
    //         })
    //     }
    // }

    const handleKeyChange = (e) => {
        setUser(user => {
            return {
                ...user,
                [e.target.name]: e.target.value
            }
        })
    }

    const [showUser, setShowUser] = useState({ ...emptyUser })
    const handleClick = () => {
        setShowUser(user)
    }

    return <>
        <input type="text" name="name" onChange={handleKeyChange} placeholder="사용자이름" value={user.name} />
        <input type="text" name="password" onChange={handleKeyChange} placeholder="비밀번호" value={user.password} />
        <input type="text" name="email" onChange={handleKeyChange} placeholder="이메일" value={user.email} />
        <button onClick={handleClick}>확인</button>
        <ul className="ul-container">
            <li>사용자이름 : {showUser.name}</li>
            <li>비밀번호 : {showUser.password}</li>
            <li>이메일 : {showUser.email}</li>
        </ul>
    </>
}
export default App;