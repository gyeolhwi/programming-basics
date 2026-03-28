import { useEffect, useRef, useState } from 'react';
import './App.css';
import Swal from 'sweetalert2';
function App() {
    // 이미지클릭 사진 받아오고 , 이름 입력하고 , 이메일 입력하고 저장하면 로컬스토리지에 저장하고 새로고침하면 로컬스토리지에 있는걸로 가지고오고 
    const emptyUser = {
        name: "",
        email: "",
        img: ""
    }
    const refs = {
        name: useRef(),
        email: useRef(),
        submit : useRef()
    }
    const { name, email,submit } = refs;
    const [datas, setDatas] = useState({ ...emptyUser });

    // const lsStorage = localStorage.getItem("user");

    useEffect(() => {
        const lsStorage = localStorage.getItem("user");
        setDatas(!lsStorage ? { ...emptyUser } : JSON.parse(lsStorage));
    }, []);

    const handleInputData = (e) => {
        setDatas(datas => {
            return {
                ...datas,
                [e.target.name]: e.target.value
            }
        })
    }

    const handleLoadImgClick = () => {
        const fileElement = document.createElement("input");
        fileElement.setAttribute("type", "file");
        fileElement.click();
        fileElement.onchange = (e) => {
            const fileReader = new FileReader();
            fileReader.onload = (e) => {
                setDatas(datas => {
                    return {
                        ...datas,
                        img: e.target.result
                    }
                })
            }
            fileReader.readAsDataURL(e.target.files[0]);
        }
    }
    const handleSaveClick = () => {
        Swal.fire({
            title: "변경",
            text: "변경할껴?",
            confirmButtonText: "넹",
            showCancelButton: true,
            cancelButtonText: "아뇨",
        }).then((result) => {
            if (result.isConfirmed) {
                localStorage.setItem("user", JSON.stringify(datas));
                Swal.fire({
                    icon: 'success',
                    text: "변경완료!"
                })
            }
            else {
                Swal.fire({
                    icon: 'error',
                    text: "취소되었습니다"
                })
                return;
            }
        });

    }
    const handleKeyDown = (e) => {
        if (e.keyCode === 13) {
            switch (e.target.name) {
                case "name":
                    email.current.focus();
                    break;
                case "email":
                    handleSaveClick(e);
                    break;
                default:
            }
        }

    }


    return (
        <div className='container'>
            <div>
                <div className="header">
                    <h2>프로필</h2>
                </div>
                <div className="img-container">
                    <div className="img-box" onClick={handleLoadImgClick}>
                        <img src={datas.img} alt="" />
                    </div>
                </div>
                <div className="input-container">
                    <div>
                        <label >이름</label>
                        <input name='name' type="text" onChange={handleInputData} onKeyDown={handleKeyDown} value={datas.name} ref={name} />
                    </div>
                    <div>
                        <label >이메일</label>
                        <input name='email' type="text" onChange={handleInputData} onKeyDown={handleKeyDown} value={datas.email} ref={email} />
                    </div>
                    <div>
                        <button name='submit' onClick={handleSaveClick} ref={submit}>저장</button>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default App;