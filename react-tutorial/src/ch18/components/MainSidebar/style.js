import { css } from "@emotion/react";

export const layout = (isSHow) => css`
    position : absolute;
    top : 0;
    left : ${isSHow ? 0 : -203}px;
    transition : all 0.3s ease-in-out;
    box-sizing : border-box;
    border-right : 2px solid #dbdbdbdb;
    width : 200px;
    height : 100%;
    background-color : white;
    box-shadow : 1px 0px 3px #00000055;
`;