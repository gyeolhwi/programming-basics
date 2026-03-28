import { css } from "@emotion/react";

export const layout = css`
    box-sizing : border-box;
    height:70px;
    `;
export const header = css`
    display:flex;
    justify-content:space-between;
    align-items : center;
    width: 100%;
    height: 100%;

    & button{
        display:flex;
        justify-content:center;
        align-items:center;
        border : 1px solid #dbdbdb;
        border-radius:4px;
        padding: 10px;
        background-color: inherit;
        cursor: pointer;
            &:hover{
                background-color: #fafafafa;
            }
            &:active{
                background-color:#eeeeee;
            }
        }
`;
export const title = css`
    display:flex;
    align-items: center;
    margin : 0;
    font-size : 22px;
    cursor: pointer;
    & > span {
        margin-left : 5px
    }

`;

// export const menuToggleButton = css`
//     display:flex;
//     justify-content:center;
//     align-items:center;
//     border : 1px solid #dbdbdb;
//     border-radius:4px;
//     padding: 10px;
//     background-color: inherit;
//     cursor: pointer;
//     &:hover{
//         background-color: #fafafafa;
//     }
//     &:active{
//         background-color:#eeeeee;
//     }
// `;