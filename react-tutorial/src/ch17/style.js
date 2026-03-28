import { css } from '@emotion/react';

export const container = css`
    display:flex;
    justify-content: center;
    align-items:center;
    transform : translateY(50%);
    margin : 0px auto;
    box-sizing : border-box;
    border : 1px solid #000000;
    padding:30px;
    width : 500px;
    height : 500px;
`;
export const boxContainer = (color) => css`
    display:flex;
    justify-content: center;
    align-items:center;
    width : 80%;
    height: 80%;
    padding: 30px;
    border : 1px solid ${color};
    box-sizing : border-box;
`;