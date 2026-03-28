import { useState } from "react";
const print = (data) => console.log(data);

function App() {
    const [num, setNum] = useState(0);
    let num2 = 0;
    const [num3, setNum3] = useState(0);


    // 함수 안이기 때문에 람다식 함수정의
    const handaleClick = (e) => {
        const value = parseInt(e.target.value);
        // setNum(num + value);
        num2 += value;
        // setNum3(n => n + value);
        // setNum3(num + value);
        setNum(num + value);
    }


    print(num);
    print(num2);
    print("num3: " + num3);

    return <>
        <h1>번호: {num}</h1>
        <h1>번호2: {num2}</h1>
        <button onClick={handaleClick} value={-10}>-10</button>
        <button onClick={handaleClick} value={-10}>-10</button>
        <button onClick={handaleClick} value={+10}>+10</button>
        <button onClick={handaleClick} value={-100}>-100</button>
        <button onClick={handaleClick} value={+100}>+100</button>


        <button onClick={(e) => { }} value={"확인"}></button>
    </>
}
export default App;