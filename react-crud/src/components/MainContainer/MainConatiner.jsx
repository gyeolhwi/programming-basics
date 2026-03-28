import React from 'react';
/** @jsxImportSource @emotion/react */
import * as s from "./style";

function MainConatiner({children}) {
    return (
        <div css={s.container}>
            {children}
        </div>
    );
}

export default MainConatiner;