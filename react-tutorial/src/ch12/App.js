import { useEffect, useState } from "react";

function App() {
    const [number, setNumber] = useState(0);
    const [number2, setNumber2] = useState(0);
    const [number3, setNumber3] = useState(0);
    useEffect(() => {
        // 마운트 지점
        console.log(number2);
        setNumber3(number * 10);
        return () => {
            // 언마운트 지점
            console.log("언마운트");
        }
    }, [number, number2]);

    const handleButtonClick = (e) => {
        setNumber(number => number + 1); // 비동기

    }

    const handleButtonClick2 = (e) => {
        setNumber2(number2 => number2 + 10); // 비동기

    }
    return (
        <>
            <h1>number : {number}</h1>
            <h1>number2 :{number2}</h1>
            <h1>number3 :{number3}</h1>
            <button onClick={handleButtonClick}>num1증가</button>
            <button onClick={handleButtonClick2}>num2증가</button>
        </>
    );
}

export default App;