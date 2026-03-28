import { css } from "@emotion/react";


export const layout = css`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100%;
    height: 500px;
    textarea{
        width: 80%;
        min-height: 250px;
        font-size: 25px;
        overflow: hidden;
        resize: none;
    }
`;