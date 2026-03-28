import { css } from "@emotion/react";

export const layout = css`
    box-sizing: border-box;
    padding: 10px;
    width: 100%;
    height: 100%;
    background-color: #efefefef;

    header{
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 10px;

        & > h2{
            font-weight: 600;
        }
    }
`;
export const todoDataBox = css`
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
    border-radius: 8px;
    padding: 10px;
    background-color: white;
    box-shadow: 0 0 3px #00000011;
    & * {
        outline: none;
        border: none;
        font-size: 15px;
            &::placeholder{
                color: #bbbbbb;
        }
    }
    & > input{
        border-bottom: 1px solid #dbdbdbdb;
        margin-bottom: 5px;
        padding-bottom: 8px;
    }
    & > textarea {
        height: 150px;
        resize: none;
        overflow-y: auto;
        &::-webkit-scrollbar{
            display: none;
        }
    }
`;
export const dateSelect = css`
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
    border-radius: 8px;
    padding: 10px;
    background-color: white;
    box-shadow: 0 0 3px #00000011;
    overflow: hidden;

    & > input{
        outline: none;
        border: none;

        &::-webkit-calendar-picker-indicator{
            cursor: pointer;
            /* width: 40px; */
            padding-left: 20px;
        }
    }
`;
export const importantSelect = css`
    display: flex;
    flex-direction: column;
    margin-bottom: 15px;
    border-radius: 8px;
    padding: 10px;
    background-color: white;
    box-shadow: 0 0 3px #00000011;
`;