import axios from 'axios';
import React, { useState } from 'react';

function RegisterSizePage(props) {

    const [size, setSize] = useState({
        sizeName: "",
    });

    const [color, setColor] = useState({
        colorName: "",
    });

    const handleInputKey = (e) => {
        setSize(size => {
            return {
                ...size,
                [e.target.name]: e.target.value
            }
        });
    }

    const handleInputKey2 = (e) => {
        setColor(color => {
            return {
                ...color,
                [e.target.name]: e.target.value
            }
        });
    }

    const handleSubmitClick = async () => {
        try {
            const response = await axios.post("http://localhost:8080/api/v1/size", size);
            console.log(response);
        } catch (e) {
            console.error(e);
        }
        setSize({ sizeName: "" });
    }

    const handleSubmitClick2 = async () =>{
        try {
            const response = await axios.post("http://localhost:8080/api/v1/color",color);
        } catch (error) {
            console.error(error);
        }
    }
    return (
        <div>
            <h1>등록페이지</h1>
            <p>
                <label htmlFor="">사이즈이름</label>
                <input type="text" name='sizeName' onChange={handleInputKey} value={size.sizeName} />
            </p>
            <p>
                <button onClick={handleSubmitClick}>등록</button>
            </p>

            <p>
                <label htmlFor="">색상이름</label>
                <input type="text" name='colorName' onChange={handleInputKey2} value={color.colorName} />
            </p>
            <p>
                <button onClick={handleSubmitClick2}>등록</button>
            </p>



        </div>
    );
}

export default RegisterSizePage;