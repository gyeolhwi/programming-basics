import { useState } from "react";

function App() {
    // const [grade, setGrade] = useState(0);
    // const [group, setGroup] = useState(0);
    // const [number, setNumber] = useState(0);
    // const [name, setName] = useState("");

    const [inputValues, setInputValues] = useState({
        grade: "",
        group: "",
        number: "",
        name: ""
    });

    const handleInputChange = (e) => {
        setInputValues({
            ...inputValues,
            [e.target.name]: e.target.value
        })
    }

    
    const emptyStudent = {
        grade: "",
        group: "",
        number: "",
        name: ""
    }

    const [student, setStudent] = useState({ ...emptyStudent })


    const handleInputChange2 = (e) => {
        /*
            const name = e.target.name;
            const value = e.target.value;
                        ↓
            const {name,value} = e.target;
            const newStudent = {
                ...student,
                [name] : value
            }
                setStudent(newStudent);

        */
        setStudent(s => {
            return {
                ...s,
                [e.target.name]: e.target.value
            }
        })
    }




    return <>
        <input type="text" name="grade" placeholder="학년" onChange={handleInputChange} value={inputValues.grade} />
        <input type="text" name="group" placeholder="반" onChange={handleInputChange} value={inputValues.group} />
        <input type="text" name="number" placeholder="번호" onChange={handleInputChange} value={inputValues.number} />
        <input type="text" name="name" placeholder="이름" onChange={handleInputChange} value={inputValues.name} />


        <ul>
            <li>학년 : {inputValues.grade}</li>
            <li>반 : {inputValues.group}</li>
            <li>번호 : {inputValues.number}</li>
            <li>이름 : {inputValues.name}</li>
        </ul>

        <input type="text" name="grade" placeholder="학년" onChange={handleInputChange2} value={student.grade} />
        <input type="text" name="group" placeholder="반" onChange={handleInputChange2} value={student.group} />
        <input type="text" name="number" placeholder="번호" onChange={handleInputChange2} value={student.number} />
        <input type="text" name="name" placeholder="이름" onChange={handleInputChange2} value={student.name} />
        <ul>
            <li>학년 : {student.grade}</li>
            <li>반 : {student.group}</li>
            <li>번호 : {student.number}</li>
            <li>이름 : {student.name}</li>
        </ul>


    </>

}
export default App;