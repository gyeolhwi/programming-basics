import React, { useState } from 'react';

function Login(props) {
    const [mode,setMode] = useState(1);
    let arr = ["랜덤","순서","역순"];
    const hadle = () =>{
        setMode(mode===1 ? 2:
                mode === 2 ? 3 : 1
        )
    }
    return (
        <div>
            <button onClick={hadle}>{arr[mode-1]}</button>
            
        </div>
    );
}

export default Login;