import axios from 'axios';
import React, { useState } from 'react';
import useInput from '../../hooks/useInput';

function PostPage(props) {
    const schoolNameInput = useInput();
    const departmentInput = useInput();
    const gradeInput = useInput();
    const nameInput = useInput();

    const schoolNameInputTeacher = useInput();
    const phoneInput = useInput();
    const addressInput = useInput();
    const nameInputTeacher = useInput();

    const [num, setNum] = useState(0);

    
    const handleClick111 =  async () => {
        setNum(num +1); //2
        }
        
        

    const handleSubmit = () => {

        const student = {
            schoolName: schoolNameInput.value,
            department: departmentInput.value,
            grade: gradeInput.value,
            name: nameInput.value
        };

        console.log(student);
        /*
        fetch("http://localhost:8080/basic/student",{
            method: "post",
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify(student)
        }).then(response =>{
            response.json().then(responseData => {
                console.log(responseData);
            })
        })
        */

        axios.post("http://localhost:8080/basic/student", student)
            .then(response => {
                console.log(response.data);
            }).catch(error => {
                console.log(error);
            });

    }

    const handleSubmitTeacher = () => {

        const teacherInfo = {
            schoolName: schoolNameInputTeacher.value,
            phone: phoneInput.value,
            address: addressInput.value,
            name: nameInputTeacher.value
        }

        axios.post("http://localhost:8080/basic/teacher", teacherInfo)
            .then(response => {
                console.log(response.data);
                alert("데이터전송완료!");

            })

    }

    return (
        <>
            <header>
                <h1>비동기 데이터 통신(POST)</h1>
            </header>
            <main>
                <h3>학생정보</h3>
                <p>
                    <label htmlFor="">학교명: </label>
                    <input onChange={schoolNameInput.onChange} value={schoolNameInput.value} type="text" />
                </p>
                <p>
                    <label htmlFor="">학과명: </label>
                    <input onChange={departmentInput.onChange} value={departmentInput.value} type="text" />
                </p>
                <p>
                    <label htmlFor="">학년: </label>
                    <input onChange={gradeInput.onChange} value={gradeInput.value} type="text" />
                </p>
                <p>
                    <label htmlFor="">이름: </label>
                    <input onChange={nameInput.onChange} value={nameInput.value} type="text" />
                </p>
                <p>
                    <button onClick={handleSubmit}>전송</button>
                </p>
                <h3>선생님정보</h3>
                <p>
                    <label htmlFor="">학교명: </label>
                    <input onChange={schoolNameInputTeacher.onChange} value={schoolNameInputTeacher.value} type="text" />
                </p>
                <p>
                    <label htmlFor="">연락처: </label>
                    <input onChange={phoneInput.onChange} value={phoneInput.value} type="text" />
                </p>
                <p>
                    <label htmlFor="">주소: </label>
                    <input onChange={addressInput.onChange} value={addressInput.value} type="text" />
                </p>
                <p>
                    <label htmlFor="">이름: </label>
                    <input onChange={nameInputTeacher.onChange} value={nameInputTeacher.value} type="text" />
                </p>
                <p>
                    <button onClick={handleSubmitTeacher}>전송</button>
                </p>

                <p>
                    {num}
                    <button onClick={handleClick111}></button>
                    <button onClick={() => console.log(num)}></button>
                </p>

            </main>
        </>
    );
}

export default PostPage;