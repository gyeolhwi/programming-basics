import { useRef } from "react";

function App() {
    const print = (data) => console.log(data);

    const inputRef = {
        a: useRef(),
        b: useRef(),
        c: useRef(),
    }
    const { a, b, c } = inputRef;

    print(a);
    print(b);
    print(c);

    const handleKeyDown = (e) => {

        if (e.keyCode === 13) {
            switch (e.target.name) {
                case "a":
                    b.current.focus();
                    break;
                case "b":
                    c.current.focus();
                    break;
                case "c":
                    a.current.focus();
                    break;
                default:
            }
        }

    }

    return <>
        <input name="a" type="text" onKeyDown={handleKeyDown} ref={a} />
        <input name="b" type="text" onKeyDown={handleKeyDown} ref={b} />
        <input name="c" type="text" onKeyDown={handleKeyDown} ref={c} />
    </>

}
export default App;