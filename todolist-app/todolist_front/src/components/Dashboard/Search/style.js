import { css } from "@emotion/react";

export const searchInputBox = css`
    position: relative;
    display: flex;
    margin-bottom: 10px;
    width: 100%;

    & > svg{
        position: absolute;
        top: 50%;
        left: 10px;
        transform: translateY(-50%);
        color: #666666;
    }
    & > input {
        /* flex-grow: 1; */
        outline: none;
        border: none;
        border-radius: 8px;
        padding: 0 10px 0 35px;
        width: 100%;
        height: 35px;
        background-color: #dddddd;
        transition: width 0.3s ease-in-out;
    
        &:focus{
            width: 80%;
        }

        &:focus + button{
            width: 20%;
        }
    }
    & > button{
        transition: width 0.5s ease-in-out;
        padding: 0;
        width: 0;
        white-space: nowrap;
        overflow: hidden;
        
    }
`;

