import { useRef, useState } from "react";
import "../ch10/App.css";
import Swal from "sweetalert2";

function App() {
    const test = {
        a : "aaa",
        b : "bbb",
    }
    console.log(test["a"]);

    const emptyUser = {
        username: "",
        password: "",
        name: ""
    }

    const inputRef = {
        username: useRef(),
        password: useRef(),
        name: useRef()
    }
    const [userList, setUserList] = useState([]);
    const [inputData, setInputData] = useState({ ...emptyUser });

    const handleInputKeyDown = (e) => {
        if (e.keyCode === 13) {
            const { username, password, name } = inputRef;
            switch (e.target.name) {
                case "username":
                    password.current.focus();
                    break;
                case "password":
                    name.current.focus();
                    break;
                case "name":
                    username.current.focus();
                    setUserList(userList => [...userList, inputData]);
                    setInputData({ ...emptyUser });
                    break;
                default:
            }
        }
    }
    const handleInputChange = (e) => {
        setInputData(inputData => {
            return {
                ...inputData,
                [e.target.name]: e.target.value
            }
        })

    }
    const handleRemoveClick = (index) => {
        Swal.fire({
            title: "Alert 테스트",
            text: "alert 테스트 입니다",
            icon: "question",
            showCancelButton: true,
            confirmButtonText: "삭제",
            confirmButtonColor: "red",
            cancelButtonText: "취소",

        }).then(result => {
            if (result.isConfirmed) {
                setUserList(userList => [...userList.filter((user, i) => i !== index)]);
                Swal.fire({
                    title: "삭제됨",
                    text: "삭제되었습니다!",
                    icon: "success"
                })
            }
        });

        if (window.confirm("정말로 삭제 하시겠습니까?")) {
            setUserList(userList => [...userList.filter((user, i) => i !== index)]);
        }
    }
    const handleEditClick = (key, index) => {
        Swal.fire({
            title: `${key} edit`,
            input: "text",
            // 객체인 경우에는 문자열 키값으로 value를 받아올 수 있음
            inputPlaceholder: userList[index][key],
            showCancelButton: true,
            cancelButtonText: "취소",
            confirmButtonText: "확인"
        }).then(result => {
            if (result.isConfirmed) {
                //주소값 대입이 아닌 이유 : 데이터 오염방지를 위해서 스프레드형식을 사용 
                setUserList(userList => [...userList.map((user, i) => {
                    console.log(typeof(userList));

                    if (i === index) {
                        return {
                            ...user,
                            [key]: result.value
                        }
                    }
                    return user;
                })]);
            }
        })
        console.log(key, index);
    }


    return <>
        <input name="username" placeholder="사용자명" type="text"
            onKeyDown={handleInputKeyDown}
            onChange={handleInputChange}
            value={inputData.username}
            ref={inputRef.username} />

        <input name="password" placeholder="비밀번호" type="text"
            onKeyDown={handleInputKeyDown}
            onChange={handleInputChange}
            value={inputData.password}
            ref={inputRef.password} />

        <input name="name" placeholder="이름" type="text"
            onKeyDown={handleInputKeyDown}
            onChange={handleInputChange}
            value={inputData.name}
            ref={inputRef.name} />
        <table>
            <thead>
                <tr>
                    <th>순서</th>
                    <th>사용자명</th>
                    <th>비밀번호</th>
                    <th>이름</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                {
                    userList.map(({ username, password, name }, index) => {
                        return (
                            <tr key={index}>
                                <td>{index + 1}</td>
                                <td name="username" onClick={() => { handleEditClick("username", index) }} >{username}</td>
                                <td name="password" onClick={() => { handleEditClick("password", index) }} >{password}</td>
                                <td name="name" onClick={() => { handleEditClick("name", index) }} >{name}</td>
                                <td><button onClick={() => { handleEditClick(index) }}>edit</button></td>
                                <td><button onClick={() => { handleRemoveClick(index) }}>삭제</button></td>
                            </tr>
                        );
                    })
                }
            </tbody>
        </table>
    </>
}
export default App;