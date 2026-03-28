import { useState } from "react";

function App() {
    const [inputValue, setInputValue] = useState("");

    const handleInputChange = (e) => {
        setInputValue(e.target.value);
    }
    const handleResetClick = (e) => {
        setInputValue("");
    }


    return <>
        <h3>값: {inputValue}</h3>
        <input type="text" onChange={handleInputChange} value={inputValue} />
        <button onClick={handleResetClick}>초기화</button>
    </>

}
export default App;