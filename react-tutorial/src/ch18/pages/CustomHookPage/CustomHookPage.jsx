import React, { useState } from 'react';
import { useInput } from '../../components/hooks/useInput';

function CustomHookPage() {
    // const { value, onChange } = useInput("test", 5);
    const test = useInput("test");
    const usernameInput = useInput("id", 20);
    const passwordInput = useInput("paswword", 10);

    return (
        <div>
            <input type="text" onChange={test.onChange} value={test.value}/>
            <input type="text" onChange={usernameInput.onChange} value={usernameInput.value}/>
            <input type="text" onChange={passwordInput.onChange} value={passwordInput.value}/>
        </div>
    );
}

export default CustomHookPage;