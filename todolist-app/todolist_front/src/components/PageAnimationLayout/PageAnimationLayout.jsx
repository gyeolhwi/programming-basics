import React, { useEffect, useState } from 'react';
/** @jsxImportSource @emotion/react */
import * as s from "./style";

function PageAnimationLayout({ isShow, setShow, children }) {

    useEffect(() => {
        setShow(true);
    }, []);

    return (
        <div css={s.layout(isShow)}>
            {children}
        </div>
    );
}

export default PageAnimationLayout;