import { useState } from "react";
const print = (data) => console.log(data);

function App() {
    const [number, setNumber] = useState(100);
    const [name, setName] = useState(null);
    const [test, testPrint] = [100, function () { print("test함수 호출") }];
    testPrint();

    print(number);
    if (number === 100) {
        setTimeout(() => setNumber(200), 2000); // 상태 변화 > 상태 변화 때 함수 재호출 (재랜더링)
        // 재랜더링 시점에는 상태 초기화는 일어나지 않는다
        // 비동기처리 : 2초라는 시간이 걸리기 때문에 다른 것 부터 처리함
    }
    if (number === 200) {
        setNumber(300); // useState의 setter는 비동기
        print(number);
    }

    if (!name) {
        setName("김결휘");
    }

    print(name);
    return <>
        <h1>number 상태 확인</h1>
        <h2>{number}</h2>

    </>

}
export default App;
